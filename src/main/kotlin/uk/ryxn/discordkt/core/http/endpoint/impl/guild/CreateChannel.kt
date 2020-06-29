package uk.ryxn.discordkt.core.http.endpoint.impl.guild

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.core.http.ApplicationJson
import uk.ryxn.discordkt.core.http.endpoint.PostEndpoint
import uk.ryxn.discordkt.entities.OmitNull
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.channel.ChannelType
import uk.ryxn.discordkt.entities.channel.PermissionOverwrite

class CreateChannel(val guildId: Snowflake, val data: Data) : PostEndpoint("/guilds/$guildId/channels", guildId, ApplicationJson, data) {
    data class Data(
        @SerializedName("name")
        val name: String,

        @SerializedName("type")
        @OmitNull
        val type: ChannelType? = null,

        @SerializedName("topic")
        @OmitNull
        val topic: String? = null,

        @SerializedName("bitrate")
        @OmitNull
        val bitrate: Int? = null,

        @SerializedName("user_limit")
        @OmitNull
        val userLimit: Int? = null,

        @SerializedName("rate_limit_per_user")
        @OmitNull
        val rateLimitPerUser: Int? = null, // msg cooldown

        @SerializedName("position")
        @OmitNull
        val position: Int? = null,

        @SerializedName("permission_overwrites")
        @OmitNull
        val permissionOverwrites: List<PermissionOverwrite>? = null,

        @SerializedName("parent_id")
        @OmitNull
        val parentId: Snowflake? = null,

        @SerializedName("nsfw")
        @OmitNull
        val nsfw: Boolean? = null
    )
}