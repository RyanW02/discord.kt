package uk.ryxn.discordkt.gateway.event

import com.google.gson.annotations.JsonAdapter
import uk.ryxn.discordkt.gateway.event.impl.*

@JsonAdapter(EventTypeAdapter::class)
enum class EventType(val eventName: String, val clazz: Class<out Event>) {
    READY("READY", Ready::class.java),
    RESUMED("RESUMED", Resumed::class.java),
    RECONNECT("RECONNECT", Reconnect::class.java),
    CHANNEL_CREATE("CHANNEL_CREATE", ChannelCreate::class.java),
    CHANNEL_UPDATE("CHANNEL_UPDATE", ChannelUpdate::class.java),
    CHANNEL_DELETE("CHANNEL_DELETE", ChannelDelete::class.java),
    CHANNEL_PINS_UPDATE("CHANNEL_PINS_UPDATE", ChannelPinsUpdate::class.java),
}
