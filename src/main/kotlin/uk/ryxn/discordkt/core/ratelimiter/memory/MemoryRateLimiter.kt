package uk.ryxn.discordkt.core.ratelimiter.memory

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withLock
import uk.ryxn.discordkt.core.http.endpoint.Endpoint
import uk.ryxn.discordkt.core.ratelimiter.RateLimiter
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.write

class MemoryRateLimiter(largeShardingBuckets: Int) : RateLimiter(largeShardingBuckets) {

    private val identifyMutexes = Array(largeShardingBuckets) { Mutex() }
    private val identifyBuckets = ConcurrentHashMap<Int, Long>() // shard ID -> last identify

    private val restBuckets = ConcurrentHashMap<Any, RateLimit>() // (major param / bucket) -> remaining
    private val restMu = Mutex()

    private val globalRateLimitExpire = AtomicLong(0)

    data class RateLimit(val remaining: AtomicInteger, var expires: Long)

    init {
        for (i in 0 until largeShardingBuckets) {
            identifyBuckets[i] = 0
        }
    }

    override suspend fun identifyWait(shardId: Int) {
        val bucketId = shardId % largeShardingBuckets

        identifyMutexes[bucketId].withLock {
            val sinceLastIdentify = System.currentTimeMillis() - identifyBuckets[bucketId]!!
            if (IDENTIFY_DELAY > sinceLastIdentify) {
                delay(IDENTIFY_DELAY - sinceLastIdentify)
            }
            identifyBuckets[bucketId] = System.currentTimeMillis()
        }
    }

    override suspend fun getTTLAndDecrease(bucket: Any): Long {
        // check global ratelimit
        val globalExpire = globalRateLimitExpire.get()
        if (globalExpire > System.currentTimeMillis()) {
            return globalExpire - System.currentTimeMillis()
        }

        // check route ratelimit
        restMu.withLock {
            var rateLimit = restBuckets[bucket]

            return if (rateLimit == null) {
                rateLimit = RateLimit(AtomicInteger(STARTING_BUCKET_CAPACITY), 0)
                restBuckets[bucket] = rateLimit

                0L
            } else {
                if (rateLimit.remaining.decrementAndGet() <= 0) {
                    rateLimit.expires - System.currentTimeMillis()
                } else {
                    0L
                }
            }
        }
    }

    override suspend fun updateRateLimit(endpoint: Endpoint, remaining: Int, resetAfter: Long) {
        val bucket = endpoint.getRateLimitParameter()

        restMu.withLock {
            val rateLimit = restBuckets[bucket]

            if (rateLimit == null) {
                restBuckets[bucket] = RateLimit(AtomicInteger(remaining), System.currentTimeMillis() + resetAfter)
            } else {
                rateLimit.remaining.set(remaining)
                rateLimit.expires = System.currentTimeMillis() + resetAfter
            }
        }
    }

    override suspend fun updateGlobalRateLimit(resetAfter: Long) {
        globalRateLimitExpire.set(System.currentTimeMillis() + resetAfter)
    }

    companion object {
        private const val IDENTIFY_DELAY = 6000L
        private const val STARTING_BUCKET_CAPACITY = 5 // some arbitrary value
    }
}