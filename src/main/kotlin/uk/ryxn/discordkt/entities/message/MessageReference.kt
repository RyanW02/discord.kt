package uk.ryxn.discordkt.entities.message

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake

class MessageReference (
    @SerializedName("message_id")
    val messageId: Snowflake?,

    @SerializedName("channel_id")
    val channelId: Snowflake,

    @SerializedName("guild_id")
    val guildId: Snowflake?
)