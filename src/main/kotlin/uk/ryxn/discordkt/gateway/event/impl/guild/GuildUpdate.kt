package uk.ryxn.discordkt.gateway.event.impl.guild

import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer
import uk.ryxn.discordkt.gateway.event.defaultDeserializer

class GuildUpdate(
    val guild: Guild
) : Event {
    companion object : CustomDeserializer<GuildUpdate>() {
        override val deserializer = defaultDeserializer<GuildUpdate, Guild>()
    }
}
