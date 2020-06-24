package uk.ryxn.discordkt.gateway.event.impl

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

class InviteDelete(
    @SerializedName("channel_id")
    val channelId: Snowflake,

    @SerializedName("guild_id")
    val guildId: Snowflake?,

    @SerializedName("code")
    val code: String
) : Event
