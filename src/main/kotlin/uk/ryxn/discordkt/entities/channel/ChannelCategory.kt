package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

data class ChannelCategory(
    @Transient
    override var shard: Shard,

    @SerializedName("guild_id")
    override val guildId: Snowflake,

    @SerializedName("position")
    override val position: Int,

    @SerializedName("permission_overwrites")
    override val permissionOverwrites: List<PermissionOverwrite>,

    @SerializedName("name")
    override val name: String?,

    @SerializedName("nsfw")
    override val nsfw: Boolean,

    @SerializedName("parent_id")
    override val parentId: Snowflake?
) : Channel(shard), GuildChannel