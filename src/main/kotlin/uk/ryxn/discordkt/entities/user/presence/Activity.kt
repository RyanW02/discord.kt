package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.OmitNull
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.emoji.Emoji

data class Activity (
    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: ActivityType,

    @SerializedName("url")
    @OmitNull
    val url: String? = null,

    @SerializedName("created_at")
    @OmitNull
    val createdAt: Long? = null, // millis since unix epoch

    @SerializedName("timestamps")
    @OmitNull
    val timestamps: Timestamps? = null,

    @SerializedName("application_id")
    @OmitNull
    val applicationId: Snowflake? = null,

    @SerializedName("details")
    @OmitNull
    val details: String? = null,

    @SerializedName("state")
    @OmitNull
    val state: String? = null,

    @SerializedName("emoji")
    @OmitNull
    val emoji: Emoji? = null,

    @SerializedName("party")
    @OmitNull
    val party: Party? = null,

    @SerializedName("assets")
    @OmitNull
    val assets: Assets? = null,

    @SerializedName("secrets")
    @OmitNull
    val secrets: Secrets? = null,

    @SerializedName("instance")
    @OmitNull
    val instance: Boolean? = null,

    @SerializedName("flags")
    @OmitNull
    val flags: Int? = null
) {
    fun hasFlag(flag: ActivityFlag) = ((flags ?: 0) and flag.value) == flag.value
}