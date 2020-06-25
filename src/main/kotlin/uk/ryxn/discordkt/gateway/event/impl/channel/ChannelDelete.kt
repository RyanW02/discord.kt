package uk.ryxn.discordkt.gateway.event.impl.channel

import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer
import uk.ryxn.discordkt.gateway.event.defaultDeserializer

class ChannelDelete(
    val channel: Channel
) : Event {
    companion object : CustomDeserializer<ChannelDelete>() {
        override val deserializer = defaultDeserializer<ChannelDelete, Channel>()
    }
}
