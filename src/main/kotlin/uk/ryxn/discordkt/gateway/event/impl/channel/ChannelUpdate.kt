package uk.ryxn.discordkt.gateway.event.impl.channel

import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer
import uk.ryxn.discordkt.gateway.event.defaultDeserializer

class ChannelUpdate(
    val channel: Channel
) : Event {
    companion object : CustomDeserializer<ChannelUpdate>() {
        override val deserializer = defaultDeserializer<ChannelUpdate, Channel>()
    }
}
