package uk.ryxn.discordkt.gateway.event

import com.google.gson.annotations.JsonAdapter
import uk.ryxn.discordkt.gateway.event.impl.Ready
import uk.ryxn.discordkt.gateway.event.impl.Reconnect
import uk.ryxn.discordkt.gateway.event.impl.Resumed

@JsonAdapter(EventTypeAdapter::class)
enum class EventType(val eventName: String, val clazz: Class<out Event>) {
    READY("READY", Ready::class.java),
    RESUMED("RESUMED", Resumed::class.java),
    RECONNECT("RECONNECT", Reconnect::class.java)
}
