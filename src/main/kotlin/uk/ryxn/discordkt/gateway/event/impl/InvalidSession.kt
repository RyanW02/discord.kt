package uk.ryxn.discordkt.gateway.event.impl

import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class InvalidSession(
    val resumable: Boolean
) : Event {
    companion object : CustomDeserializer<InvalidSession>() {
        override val deserializer = createDeserializer { json, _, _ -> InvalidSession(json.asBoolean) }
    }
}
