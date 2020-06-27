package uk.ryxn.discordkt.gateway.payload

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.SkipSerialisation
import uk.ryxn.discordkt.gateway.Shard

abstract class Payload(@Transient open val shard: Shard) {
    @SerializedName("op")
    var opcode: Int? = null

    @SerializedName("s")
    @SkipSerialisation
    open var sequenceNumber: Int? = null
        internal set

    fun setOpcode(data: PayloadData) {
        this.opcode = data.code
    }

    open suspend fun handle(shard: Shard) {}
}