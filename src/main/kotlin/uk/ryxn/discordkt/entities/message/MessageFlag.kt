package uk.ryxn.discordkt.entities.message

enum class MessageFlag(val value: Int) {
    CROSSPOSTED(1 shl 0),
    IS_CROSSPOST(1 shl 1),
    SUPPRESS_EMBEDS(1 shl 2),
    SOURCE_MESSAGE_DELETED(1 shl 3),
    URGENT(1 shl 4),
}