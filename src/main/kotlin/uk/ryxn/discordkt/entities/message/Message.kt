package uk.ryxn.discordkt.entities.message

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.member.Member
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.Shard
import java.time.OffsetDateTime

class Message (
    shard: Shard,

    @SerializedName("id")
    val id: Snowflake,

    @SerializedName("channel_id")
    val channelId: Snowflake,

    @SerializedName("guild_id")
    val guildId: Snowflake?,

    @SerializedName("author")
    val author: User,

    @SerializedName("member")
    val member: Member?,

    @SerializedName("content")
    val content: String,

    @SerializedName("timestamp")
    val timestamp: OffsetDateTime,

    @SerializedName("edited_timestamp")
    val editedTimestamp: OffsetDateTime?,

    @SerializedName("tts")
    val tts: Boolean,

    @SerializedName("mention_everyone")
    val mentionEveryone: Boolean,

    @SerializedName("mentions")
) : Entity(shard)