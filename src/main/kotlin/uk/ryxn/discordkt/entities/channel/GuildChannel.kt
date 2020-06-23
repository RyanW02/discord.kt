package uk.ryxn.discordkt.entities.channel

import uk.ryxn.discordkt.entities.Snowflake

interface GuildChannel {
    val guildId: Snowflake
    var position: Int
    var permissionOverwrites: List<PermissionOverwrite>
    var name: String?
    var nsfw: Boolean
    var parentId: Snowflake?
}