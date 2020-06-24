package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.emoji.Emoji

data class Activity (
    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: ActivityType,

    @SerializedName("url")
    val url: String?,

    @SerializedName("created_at")
    val createdAt: Long, // millis since unix epoch

    @SerializedName("timestamps")
    val timestamps: Timestamps?,

    @SerializedName("application_id")
    val snowflake: Snowflake?,

    @SerializedName("details")
    val details: String?,

    @SerializedName("state")
    val state: String?,

    @SerializedName("emoji")
    val emoji: Emoji?,

    @SerializedName("party")
    val party: Party?,

    @SerializedName("assets")
    val assets: Assets?,

    @SerializedName("secrets")
    val secrets: Secrets?,

    @SerializedName("instance")
    val instance: Boolean?,

    @SerializedName("flags")
    val flags: Int
) {
    fun hasFlag(flag: ActivityFlag) = (flags and flag.value) == flag.value
}