package uk.ryxn.discordkt.entities.guild

enum class SystemChannelFlag(val value: Int) {
    SUPPRESS_JOIN_NOTIFICATIONS(1 shl 0),
    SUPPRESS_PREMIUM_SUBSCRIPTIONS(1 shl 1),
}