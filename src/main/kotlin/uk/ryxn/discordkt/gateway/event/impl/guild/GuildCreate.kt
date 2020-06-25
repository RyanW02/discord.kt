package uk.ryxn.discordkt.gateway.event.impl.guild

import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.defaultDeserializer

class GuildCreate(
    val guild: Guild
) : Event {
    companion object : CustomDeserializer<GuildCreate>() {
        override val deserializer = defaultDeserializer<GuildCreate, Guild>()
    }
}
