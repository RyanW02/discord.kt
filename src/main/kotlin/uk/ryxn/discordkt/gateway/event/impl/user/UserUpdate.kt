package uk.ryxn.discordkt.gateway.event.impl.user

import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.defaultDeserializer

class UserUpdate(
    val user: User
) : Event {
    companion object : CustomDeserializer<UserUpdate>() {
        override val deserializer = defaultDeserializer<UserUpdate, User>()
    }
}
