package uk.ryxn.discordkt.gateway.event.impl.channel

import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.defaultDeserializer

class ChannelCreate(
    val channel: Channel
) : Event {
    companion object : CustomDeserializer<ChannelCreate>() {
        override val deserializer = defaultDeserializer<ChannelCreate, Channel>()
    }
}
