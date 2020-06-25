package uk.ryxn.discordkt.gateway.event.impl.guild

import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.entities.guild.UnavailableGuild
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer
import uk.ryxn.discordkt.gateway.event.defaultDeserializer

class GuildDelete(
    val guild: UnavailableGuild
) : Event {
    // was kicked / left, rather than guild offline due to outage
    fun wasRemoved() = guild.unavailable == null

    companion object : CustomDeserializer<GuildDelete>() {
        override val deserializer = defaultDeserializer<GuildDelete, Guild>()
    }
}
