package uk.ryxn.discordkt.entities.message

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.entities.channel.Reaction
import uk.ryxn.discordkt.entities.guild.member.Member
import uk.ryxn.discordkt.entities.message.embed.Embed
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.entities.user.UserFlag
import uk.ryxn.discordkt.entities.user.UserWithMember
import uk.ryxn.discordkt.gateway.Shard
import java.time.OffsetDateTime

// TODO: Role objects
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
    val mentions: List<UserWithMember>,

    @SerializedName("mention_roles")
    val mentionedRoleIds: List<Snowflake>,

    @SerializedName("mention_channels")
    val mentionChannels: List<Channel>?, // only available in crossposted messages

    @SerializedName("attachments")
    val attachments: List<Attachment>,

    @SerializedName("embeds")
    val embeds: List<Embed>,

    @SerializedName("reactions")
    val reactions: List<Reaction>?,

    @SerializedName("nonce")
    val nonce: Any?,

    @SerializedName("pinned")
    val pinned: Boolean,

    @SerializedName("webhook_id")
    val webhookId: Snowflake?,

    @SerializedName("type")
    val type: MessageType,

    @SerializedName("activity")
    val activity: MessageActivity?,

    @SerializedName("application")
    val application: MessageApplication?,

    @SerializedName("message_reference")
    val messageReference: MessageReference?, // only available on crossposted messages

    @SerializedName("flags")
    val flags: Int?
) : Entity(shard) {
    fun hasFlag(flag: MessageFlag) = ((flags ?: 0) and flag.value) == flag.value
}