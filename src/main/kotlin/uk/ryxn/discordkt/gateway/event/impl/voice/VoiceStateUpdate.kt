package uk.ryxn.discordkt.gateway.event.impl.voice

import uk.ryxn.discordkt.entities.voice.VoiceState
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.defaultDeserializer

class VoiceStateUpdate(
    val voiceState: VoiceState
) : Event {
    companion object : CustomDeserializer<VoiceStateUpdate>() {
        override val deserializer = defaultDeserializer<VoiceStateUpdate, VoiceState>()
    }
}
