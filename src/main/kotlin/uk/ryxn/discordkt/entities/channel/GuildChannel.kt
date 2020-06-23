package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

open class GuildChannel(shard: Shard) : Channel(shard) {
    @SerializedName("guild_id")
    var guildId: Snowflake? = null

    @SerializedName("position")
    var position: Int? = null

    @SerializedName("permission_overwrites")
    var permissionOverwrites: List<PermissionOverwrite> = emptyList()

    @SerializedName("name")
    var name: String? = null

    @SerializedName("nsfw")
    var nsfw: Boolean = false

    @SerializedName("parent_id")
    var parentId: Snowflake? = null
}