package uk.ryxn.discordkt.entities.invite

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.entities.user.User

open class Invite {
    @SerializedName("code")
    lateinit var code: String
        private set

    @SerializedName("guild")
    val guild: Guild? = null

    @SerializedName("channel")
    lateinit var channel: Channel
        private set

    @SerializedName("inviter")
    val inviter: User? = null

    @SerializedName("target_user")
    val targetUser: User? = null

    @SerializedName("target_user_type")
    val targetUserType: TargetUserType? = null

    @SerializedName("approximate_presence_count")
    val approximatePresenceCount: Int? = null

    @SerializedName("approximate_member_count")
    val approximateMemberCount: Int? = null
}