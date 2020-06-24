package uk.ryxn.discordkt.gateway.event.impl

import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class GuildUpdate(
    val guild: Guild
) : Event {
    companion object : CustomDeserializer<GuildUpdate>() {
        override val deserializer = createDeserializer { json, type, ctx ->
            GuildUpdate(ctx.deserialize(json, type))
        }
    }
}
