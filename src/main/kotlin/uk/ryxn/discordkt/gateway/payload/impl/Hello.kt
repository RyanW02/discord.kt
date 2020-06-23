package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.gateway.payload.Payload

class Hello : Payload() {

    @SerializedName("d")
    lateinit var data: Data

    data class Data(
        @SerializedName("heartbeat_interval")
        val heartbeatInterval: Long
    )
}