package uk.ryxn.discordkt.gateway

import uk.ryxn.discordkt.entities.user.presence.UpdateStatus

class ShardOptions {
    lateinit var token: String
    var shardId: Int = 0
    var totalShards: Int = 1
    var status: UpdateStatus? = null
}