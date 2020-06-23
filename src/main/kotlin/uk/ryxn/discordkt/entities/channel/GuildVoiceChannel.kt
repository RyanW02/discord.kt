package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

data class GuildVoiceChannel(
    @Transient
    override var shard: Shard,

    @SerializedName("guild_id")
    override var guildId: Snowflake,

    @SerializedName("position")
    override var position: Int,

    @SerializedName("permission_overwrites")
    override var permissionOverwrites: List<PermissionOverwrite>,

    @SerializedName("name")
    override var name: String?,

    @SerializedName("nsfw")
    override var nsfw: Boolean,

    @SerializedName("parent_id")
    override var parentId: Snowflake?,

    @SerializedName("bitrate")
    val  bitrate: Int,

    @SerializedName("user_limit")
    val userLimit: Int
) : Channel(shard), GuildChannel