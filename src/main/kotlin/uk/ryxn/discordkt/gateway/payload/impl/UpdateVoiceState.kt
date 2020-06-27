package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.OmitNull
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.payload.PayloadData
import uk.ryxn.discordkt.gateway.payload.Payload

open class UpdateVoiceState(
    @Transient
    override val shard: Shard
) : Payload(shard) {

    init {
        setOpcode(PayloadData.VOICE_STATE_UPDATE)
    }

    @SerializedName("d")
    lateinit var data: Data

    companion object {
        fun create(shard: Shard, data: Data): UpdateVoiceState {
            val payload = UpdateVoiceState(shard)
            payload.data = data
            return payload
        }
    }

    // you required to have one of query OR user_ids
    data class Data(
        @SerializedName("guild_id")
        val guildId: Snowflake,

        @SerializedName("channel_id")
        val channelId: Snowflake? = null,

        @SerializedName("self_mute")
        val selfMute: Boolean,

        @SerializedName("self_deaf")
        val selfDeaf: Boolean
    )
}