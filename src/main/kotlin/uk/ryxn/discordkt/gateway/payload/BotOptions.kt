package uk.ryxn.discordkt.gateway.payload

import uk.ryxn.discordkt.core.ratelimiter.RateLimiter
import uk.ryxn.discordkt.core.ratelimiter.memory.MemoryRateLimiter
import uk.ryxn.discordkt.entities.user.presence.UpdateStatus

class BotOptions {
    lateinit var token: String
    var rateLimiter: RateLimiter = MemoryRateLimiter(1)

    var totalShards: Int = 1
    var lowestShard: Int = 0 // Inclusive
    var highestShard: Int = 1 // Exclusive

    var status: UpdateStatus? = null
}
