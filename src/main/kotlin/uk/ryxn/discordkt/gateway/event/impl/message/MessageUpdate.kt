package uk.ryxn.discordkt.gateway.event.impl.message

import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.entities.message.Message
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer
import uk.ryxn.discordkt.gateway.event.defaultDeserializer
import uk.ryxn.discordkt.gateway.event.impl.guild.GuildDelete

class MessageUpdate(
    val message: Message
) : Event {
    companion object : CustomDeserializer<MessageUpdate>() {
        override val deserializer = defaultDeserializer<MessageUpdate, Message>()
    }
}
