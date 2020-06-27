package uk.ryxn.discordkt.core.ratelimiter

abstract class RateLimiter(val largeShardingBuckets: Int) {
    abstract suspend fun identifyWait(shardId: Int)
}