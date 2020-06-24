package uk.ryxn.discordkt.entities.guild

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

open class UnavailableGuild(shard: Shard) : Entity(shard) {
    @SerializedName("id")
    var id: Snowflake = 0u
        private set

    @SerializedName("unavailable")
    var unavailable: Boolean? = null
        private set
}