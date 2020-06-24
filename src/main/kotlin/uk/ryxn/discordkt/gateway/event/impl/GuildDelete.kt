package uk.ryxn.discordkt.gateway.event.impl

import uk.ryxn.discordkt.entities.guild.UnavailableGuild
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class GuildDelete(
    val guild: UnavailableGuild
) : Event {
    // was kicked / left, rather than guild offline due to outage
    fun wasRemoved() = guild.unavailable == null

    companion object : CustomDeserializer<GuildDelete>() {
        override val deserializer = createDeserializer { json, type, ctx ->
            GuildDelete(ctx.deserialize(json, type))
        }
    }
}
