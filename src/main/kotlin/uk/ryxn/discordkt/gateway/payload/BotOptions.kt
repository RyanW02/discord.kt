package uk.ryxn.discordkt.gateway.payload

class BotOptions {
    lateinit var token: String

    var totalShards: Int = 1
    var lowestShard: Int = 0 // Inclusive
    var highestShard: Int = 1 // Exclusive
}
