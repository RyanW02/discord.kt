package uk.ryxn.discordkt.entities.guild.member

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.Shard
import java.time.OffsetDateTime

// TODO: Role IDs
open class Member (
    shard: Shard
) : Entity(shard) {
    @SerializedName("user")
    var user: User? = null // not included in MESSAGE_CREATE or MESSAGE_UPDATE events
        private set

    @SerializedName("nick")
    var nick: String? = null
        private set

    @SerializedName("roles")
    lateinit var roleIds: List<Snowflake>
        private set

    @SerializedName("joined_at")
    lateinit var joinedAt: OffsetDateTime
        private set

    @SerializedName("premium_since")
    var premiumSince: OffsetDateTime? = null
        private set

    @SerializedName("deaf")
    var deaf: Boolean = false
        private set

    @SerializedName("mute")
    var mute: Boolean = false
        private set
}