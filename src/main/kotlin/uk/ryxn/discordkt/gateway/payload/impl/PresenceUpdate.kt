package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.OmitNull
import uk.ryxn.discordkt.entities.user.presence.UpdateStatus
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.payload.PayloadData
import uk.ryxn.discordkt.gateway.payload.Payload

open class PresenceUpdate(
    @Transient
    override val shard: Shard
) : Payload(shard) {

    init {
        setOpcode(PayloadData.PRESENCE_UPDATE)
    }

    @SerializedName("d")
    lateinit var data: UpdateStatus

    companion object {
        fun create(shard: Shard, data: UpdateStatus): PresenceUpdate {
            val payload = PresenceUpdate(shard)

            payload.data = data

            return payload
        }
    }
}