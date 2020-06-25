package uk.ryxn.discordkt.gateway

class ShardOptions {
    lateinit var token: String
    var shardId: Int = 0
    var totalShards: Int = 1
}