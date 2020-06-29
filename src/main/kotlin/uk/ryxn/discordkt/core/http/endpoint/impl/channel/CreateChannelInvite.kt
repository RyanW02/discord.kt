package uk.ryxn.discordkt.core.http.endpoint.impl.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.core.http.ApplicationJson
import uk.ryxn.discordkt.core.http.endpoint.PostEndpoint
import uk.ryxn.discordkt.entities.OmitNull
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.channel.ChannelType
import uk.ryxn.discordkt.entities.channel.PermissionOverwrite
import uk.ryxn.discordkt.entities.invite.TargetUserType

class CreateChannelInvite(val channelId: Snowflake, val data: Data) : PostEndpoint("/channels/$channelId/invites", channelId, ApplicationJson, data) {
    data class Data(
        @SerializedName("max_age")
        @OmitNull
        val maxAge: Int? = null, // seconds, 0 for never

        @SerializedName("max_uses")
        @OmitNull
        val maxUses: Int? = null,

        @SerializedName("temporary")
        @OmitNull
        val temporary: Boolean? = null,

        @SerializedName("unique")
        @OmitNull
        val unique: Boolean? = null,

        @SerializedName("target_user")
        @OmitNull
        val targetUserId: Snowflake? = null,

        @SerializedName("target_user_type")
        @OmitNull
        val targetUserType: TargetUserType? = null
    )
}