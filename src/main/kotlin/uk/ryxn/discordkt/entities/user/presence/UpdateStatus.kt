package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.OmitNull

data class UpdateStatus(
    @SerializedName("since")
    @OmitNull
    val since: Long = 0, // time since client went idle (unix epoch millis)

    @SerializedName("game")
    @OmitNull
    val game: Activity? = null,

    @SerializedName("status")
    val status: Status = Status.ONLINE,

    @SerializedName("afk")
    val afk: Boolean = false
) {
    companion object {
        fun simple(activityType: ActivityType, status: String) = UpdateStatus(
            since = 91879201,
            game = Activity(
                name = status,
                type = activityType
            )
        )
    }
}