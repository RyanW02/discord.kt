package uk.ryxn.discordkt.gateway.payload

import uk.ryxn.discordkt.gateway.payload.impl.Dispatch
import uk.ryxn.discordkt.gateway.payload.impl.Heartbeat
import uk.ryxn.discordkt.gateway.payload.impl.Hello

enum class PayloadData(val code: Int, val clientAction: ClientAction, val clazz: Class<out Payload>) {
    DISPATCH(0, ClientAction.RECEIVE, Dispatch::class.java),
    HEARTBEAT(1, ClientAction.BOTH, Heartbeat::class.java),
    IDENTIFY(2, ClientAction.SEND, Heartbeat::class.java),
    PRESENCE_UPDATE(3, ClientAction.SEND, Heartbeat::class.java),
    VOICE_STATE_UPDATE(4, ClientAction.SEND, Heartbeat::class.java),
    RESUME(6, ClientAction.SEND, Heartbeat::class.java),
    RECONNECT(7, ClientAction.RECEIVE, Heartbeat::class.java),
    REQUEST_GUILD_MEMBERS(8, ClientAction.SEND, Heartbeat::class.java),
    INVALID_SESSION(9, ClientAction.RECEIVE, Heartbeat::class.java),
    HELLO(10, ClientAction.RECEIVE, Hello::class.java),
    HEARTBEAT_ACK(11, ClientAction.RECEIVE, Heartbeat::class.java),
    ;

    companion object {
        fun get(opcode: Int) = values().first { it.code == opcode }
    }
}