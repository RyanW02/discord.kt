package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.gateway.payload.Payload

class Dispatch : Payload() {
    @SerializedName("d")
    lateinit var data: JsonObject

    @SerializedName("t")
    lateinit var eventName: String
}