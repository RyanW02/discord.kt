package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.Shard

// TODO: Get user roles
class PresenceUpdate (
    shard: Shard,

    @SerializedName("user")
    val user: User,

    @SerializedName("roles")
    val roleIds: List<Snowflake>,

    @SerializedName("activity")
    val user: User,
) : Entity(shard)