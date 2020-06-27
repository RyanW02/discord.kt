package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.OmitNull
import uk.ryxn.discordkt.entities.user.presence.UpdateStatus
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.ShardData
import uk.ryxn.discordkt.gateway.payload.PayloadData
import uk.ryxn.discordkt.gateway.payload.Payload

open class Identify(
    @Transient
    override val shard: Shard
) : Payload(shard) {

    init {
        setOpcode(PayloadData.IDENTIFY)
    }

    @SerializedName("d")
    lateinit var data: Data

    companion object {
        val defaultProperties = Properties(os = "linux", browser = "discord.kt", device = "discord.kt")

        fun create(shard: Shard, data: Data): Identify {
            val identify = Identify(shard)

            identify.data = data

            return identify
        }
    }

    data class Data(
        @SerializedName("token")
        val token: String,

        @SerializedName("properties")
        val properties: Properties = defaultProperties,

        @SerializedName("compress")
        val compress: Boolean = false,

        @SerializedName("large_threshold")
        val largeThreshold: Int = 50,

        @SerializedName("shard")
        val shard: ShardData,

        @SerializedName("presence")
        @OmitNull
        val presence: UpdateStatus? = null,

        @SerializedName("guild_subscriptions")
        val guildSubscriptions: Boolean = true,

        @SerializedName("intents")
        @OmitNull
        val intents: Int? = null
    )

    data class Properties(
        @SerializedName("\$os")
        val os: String,

        @SerializedName("\$browser")
        val browser: String,

        @SerializedName("\$device")
        val device: String
    )
}