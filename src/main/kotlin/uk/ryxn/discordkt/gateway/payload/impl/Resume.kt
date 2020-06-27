package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.payload.PayloadData
import uk.ryxn.discordkt.gateway.payload.Payload

open class Resume(
    @Transient
    override val shard: Shard
) : Payload(shard) {

    init {
        setOpcode(PayloadData.RESUME)
    }

    @SerializedName("d")
    lateinit var data: Data

    companion object {
        fun create(shard: Shard, data: Data): Resume {
            val payload = Resume(shard)
            payload.data = data
            return payload
        }
    }

    data class Data(
        @SerializedName("token")
        val token: String,

        @SerializedName("session_id")
        val sessionId: String,

        @SerializedName("seq")
        val sequenceNumber: Int
    )
}