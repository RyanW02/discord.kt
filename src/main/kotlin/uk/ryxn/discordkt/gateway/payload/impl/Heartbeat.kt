package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.gateway.payload.PayloadData
import uk.ryxn.discordkt.gateway.payload.Payload

open class Heartbeat : Payload() {

    @SerializedName("d")
    var lastSequenceNumber: Int? = null

    companion object {
        fun create(lastSequenceNumber: Int?): Heartbeat {
            val heartbeat = Heartbeat()

            heartbeat.setOpcode(PayloadData.HEARTBEAT)
            heartbeat.lastSequenceNumber = lastSequenceNumber

            return heartbeat
        }
    }
}