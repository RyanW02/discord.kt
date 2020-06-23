package uk.ryxn.discordkt.gateway.payload

enum class ClientAction {
    RECEIVE,
    SEND,
    BOTH,
    ;

    val isSend: Boolean
        get() = this == SEND || this == BOTH

    val isReceive: Boolean
        get() = this == RECEIVE || this == BOTH
}