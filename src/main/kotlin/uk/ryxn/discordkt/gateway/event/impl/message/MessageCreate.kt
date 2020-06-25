package uk.ryxn.discordkt.gateway.event.impl.message

import uk.ryxn.discordkt.entities.message.Message
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.defaultDeserializer

class MessageCreate(
    val message: Message
) : Event {
    companion object : CustomDeserializer<MessageCreate>() {
        override val deserializer = defaultDeserializer<MessageCreate, Message>()
    }
}
