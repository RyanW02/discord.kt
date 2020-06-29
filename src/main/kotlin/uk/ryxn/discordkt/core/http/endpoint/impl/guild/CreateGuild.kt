package uk.ryxn.discordkt.core.http.endpoint.impl.guild

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.core.http.ApplicationJson
import uk.ryxn.discordkt.core.http.endpoint.PostEndpoint
import uk.ryxn.discordkt.entities.OmitNull
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.ExplicitContentFilter
import uk.ryxn.discordkt.entities.guild.MessageNotificationLevel
import uk.ryxn.discordkt.entities.guild.VerificationLevel
import uk.ryxn.discordkt.entities.image.ImageData
import java.nio.channels.Channel
import javax.management.relation.Role

class CreateGuild(val data: Data) : PostEndpoint("/guilds", 0u, ApplicationJson, data) {
    data class Data(
        @SerializedName("name")
        val name: String,

        @SerializedName("region")
        @OmitNull
        val region: String? = null,

        @SerializedName("icon")
        @OmitNull
        val icon: ImageData? = null,

        @SerializedName("verification_level")
        @OmitNull
        val verificationLevel: VerificationLevel? = null,

        @SerializedName("default_message_notifications")
        @OmitNull
        val defaultMessageNotifications: MessageNotificationLevel? = null,

        @SerializedName("explicit_content_filter")
        @OmitNull
        val explicitContentFilter: ExplicitContentFilter? = null,

        /**
         * First element is the @everyone role
         */
        @SerializedName("roles")
        @OmitNull
        val roles: List<Role>? = null,

        @SerializedName("channels")
        @OmitNull
        val channels: List<Channel>? = null,

        @SerializedName("afk_channel_id")
        @OmitNull
        val afkChannelId: Snowflake? = null,

        @SerializedName("afk_timeout")
        @OmitNull
        val afkTimeout: Int? = null,

        @SerializedName("system_channel_id")
        @OmitNull
        val systemChannelId: Snowflake? = null
    )
}