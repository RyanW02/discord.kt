package uk.ryxn.discordkt.gateway.event.impl

import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class GuildCreate(
    val guild: Guild
) : Event {
    companion object : CustomDeserializer<GuildCreate>() {
        override val deserializer = createDeserializer { json, type, ctx ->
            GuildCreate(ctx.deserialize(json, type))
        }
    }
}
