package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.guild.emoji.Emoji

class Reaction (
    @SerializedName("count")
    val count: Int,

    @SerializedName("me")
    val me: Boolean,

    @SerializedName("emoji")
    val emoji: Emoji
)