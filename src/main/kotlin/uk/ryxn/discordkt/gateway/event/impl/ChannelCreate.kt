package uk.ryxn.discordkt.gateway.event.impl

import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class ChannelCreate(
    val channel: Channel
) : Event {
    companion object : CustomDeserializer<ChannelCreate>() {
        override val deserializer = createDeserializer { json, type, ctx ->
            ChannelCreate(ctx.deserialize(json, type))
        }
    }
}
