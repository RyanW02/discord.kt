package uk.ryxn.discordkt.entities.voice

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.member.Member
import uk.ryxn.discordkt.gateway.Shard

class VoiceState (
    shard: Shard,

    @SerializedName("guild_id")
    val guildId: Snowflake?,

    @SerializedName("channel_id")
    val channelId: Snowflake?,

    @SerializedName("user_id")
    val userId: Snowflake,

    @SerializedName("member")
    val member: Member?,

    @SerializedName("session_id")
    val sessionId: String,

    @SerializedName("deaf")
    val deaf: Boolean,

    @SerializedName("mute")
    val mute: Boolean,

    @SerializedName("self_deaf")
    val selfDeaf: Boolean,

    @SerializedName("self_mute")
    val selfMute: Boolean,

    @SerializedName("self_stream")
    val selfStream: Boolean?,

    @SerializedName("suppress")
    val suppress: Boolean
) : Entity(shard)