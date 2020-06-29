package uk.ryxn.discordkt.core.ratelimiter

import kotlinx.coroutines.delay
import uk.ryxn.discordkt.core.http.endpoint.Endpoint

abstract class RateLimiter(val largeShardingBuckets: Int) {
    abstract suspend fun identifyWait(shardId: Int)

    internal abstract suspend fun getTTLAndDecrease(bucket: Any): Long
    abstract suspend fun updateRateLimit(endpoint: Endpoint, remaining: Int, resetAfter: Long)

    abstract suspend fun updateGlobalRateLimit(resetAfter: Long)

    suspend fun executeCall(endpoint: Endpoint) {
        val ttl = getTTLAndDecrease(endpoint.getRateLimitParameter())

        if (ttl > 0) {
            delay(ttl)
            executeCall(endpoint)
        }
    }
}