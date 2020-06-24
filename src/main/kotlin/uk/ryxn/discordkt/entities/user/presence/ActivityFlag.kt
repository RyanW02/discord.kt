package uk.ryxn.discordkt.entities.user.presence

enum class ActivityFlag(val value: Int) {
    INSTANCE(1 shl 0),
    JOIN(1 shl 1),
    SPECTATE(1 shl 2),
    JOIN_REQUEST(1 shl 3),
    SYNC(1 shl 4),
    PLAY(1 shl 5),
}