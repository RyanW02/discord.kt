package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.gateway.ShardData
import uk.ryxn.discordkt.gateway.payload.PayloadData
import uk.ryxn.discordkt.gateway.payload.Payload

open class Identify : Payload() {

    @SerializedName("d")
    lateinit var data: Data

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
        val presence: Any? = null, // TODO

        @SerializedName("guild_subscriptions")
        val guildSubscriptions: Boolean = true,

        @SerializedName("intents")
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

    companion object {
        val defaultProperties = Properties(os = "linux", browser = "discord.kt", device = "discord.kt")

        fun create(data: Data): Identify {
            val identify = Identify()

            identify.setOpcode(PayloadData.IDENTIFY)
            identify.data = data

            return identify
        }
    }
}