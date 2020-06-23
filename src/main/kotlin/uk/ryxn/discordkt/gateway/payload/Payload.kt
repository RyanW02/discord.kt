package uk.ryxn.discordkt.gateway.payload

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

abstract class Payload {
    @SerializedName("op")
    @Expose(serialize = true, deserialize = true)
    var opcode: Int? = null

    @SerializedName("s")
    @Expose(serialize = false, deserialize = true)
    var sequenceNumber: Int? = null

    fun setOpcode(data: PayloadData) {
        this.opcode = data.code
    }
}