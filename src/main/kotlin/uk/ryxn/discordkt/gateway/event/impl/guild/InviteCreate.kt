package uk.ryxn.discordkt.gateway.event.impl.guild

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.entities.guild.emoji.Emoji
import uk.ryxn.discordkt.entities.guild.role.Role
import uk.ryxn.discordkt.entities.invite.TargetUserType
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer
import java.time.OffsetDateTime

class InviteCreate(
    @SerializedName("channel_id")
    val channelId: Snowflake,

    @SerializedName("code")
    val code: String,

    @SerializedName("created_at")
    val createdAt: OffsetDateTime,

    @SerializedName("guild_id")
    val guildId: Snowflake?,

    @SerializedName("inviter")
    val inviter: User?,

    @SerializedName("max_age")
    val maxAge: Int, // seconds

    @SerializedName("max_uses")
    val maxUses: Int,

    @SerializedName("target_user")
    val targetUser: User?,

    @SerializedName("target_user_type")
    val targetUserType: TargetUserType?,

    @SerializedName("temporary")
    val temporary: Boolean,

    @SerializedName("uses")
    val uses: Int // will always be 0
) : Event
