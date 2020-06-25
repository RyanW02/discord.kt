package uk.ryxn.discordkt.gateway.event.impl.message

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.emoji.Emoji
import uk.ryxn.discordkt.entities.guild.member.Member
import uk.ryxn.discordkt.entities.message.Message
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class MessageReactionAdd(
    @SerializedName("user_id")
    val userId: Snowflake,

    @SerializedName("channel_id")
    val channelId: Snowflake,

    @SerializedName("message_id")
    val messageId: Snowflake,

    @SerializedName("guild_id")
    val guildId: Snowflake?,

    @SerializedName("member")
    val member: Member?,

    @SerializedName("emoji")
    val emoji: Emoji
) : Event
