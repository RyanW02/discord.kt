package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.payload.Payload

class Hello(
    @Transient
    override val shard: Shard
) : Payload(shard) {

    @SerializedName("d")
    lateinit var data: Data

    data class Data(
        @SerializedName("heartbeat_interval")
        val heartbeatInterval: Long
    )

    override fun handle(shard: Shard) {
        TODO("Not yet implemented")
    }
}