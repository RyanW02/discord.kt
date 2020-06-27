package uk.ryxn.discordkt.core.ratelimiter.memory

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import uk.ryxn.discordkt.core.ratelimiter.RateLimiter
import java.util.concurrent.ConcurrentHashMap

class MemoryRateLimiter(largeShardingBuckets: Int) : RateLimiter(largeShardingBuckets) {

    private val identifyMutexes = Array(largeShardingBuckets) { Mutex() }
    private val identifyBuckets = ConcurrentHashMap<Int, Long>() // shard ID -> last identify

    init {
        for(i in 0 until largeShardingBuckets) {
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

    companion object {
        private const val IDENTIFY_DELAY = 6000L
    }
}