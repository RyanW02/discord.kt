package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.payload.PayloadData
import uk.ryxn.discordkt.gateway.payload.Payload

open class Heartbeat(
    @Transient
    override val shard: Shard
) : Payload(shard) {

    @SerializedName("d")
    var lastSequenceNumber: Int? = null

    companion object {
        fun create(shard: Shard, lastSequenceNumber: Int?): Heartbeat {
            val heartbeat = Heartbeat(shard)

            heartbeat.setOpcode(PayloadData.HEARTBEAT)
            heartbeat.lastSequenceNumber = lastSequenceNumber

            return heartbeat
        }
    }

    override fun handle(shard: Shard) {
        TODO("Not yet implemented")
    }
}