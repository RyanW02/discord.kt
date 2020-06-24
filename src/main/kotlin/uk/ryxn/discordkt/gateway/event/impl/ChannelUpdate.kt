package uk.ryxn.discordkt.gateway.event.impl

import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class ChannelUpdate(
    val channel: Channel
) : Event {
    companion object : CustomDeserializer<ChannelUpdate>() {
        override val deserializer = createDeserializer { json, type, ctx ->
            ChannelUpdate(ctx.deserialize(json, type))
        }
    }
}
