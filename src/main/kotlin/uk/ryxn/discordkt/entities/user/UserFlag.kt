package uk.ryxn.discordkt.entities.user

enum class UserFlag(val value: Int) {
    NONE(0),
    DISCORD_EMPLOYEE(1 shl 0),
    DISCORD_PARTNER(1 shl 1),
    HYPESQUAD_EVENTS(1 shl 2),
    BUG_HUNTER_LEVEL_1(1 shl 3),
    HOUSE_BRAVERY(1 shl 6),
    HOUSE_BRILLIANCE(1 shl 7),
    HOUSE_BALANCE(1 shl 8),
    EARLY_SUPPORTER(1 shl 9),
    TEAM_USER(1 shl 10),
    SYSTEM(1 shl 12),
    BUG_HUNTER_LEVEL_2(1 shl 14),
    VERIFIED_BOT(1 shl 16),
    VERIFIED_BOT_DEVELOPER(1 shl 17),
}