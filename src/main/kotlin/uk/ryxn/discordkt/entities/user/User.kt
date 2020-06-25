package uk.ryxn.discordkt.entities.user

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Hash
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

open class User(
    shard: Shard
) : Entity(shard) {
    @SerializedName("id")
    var id: Snowflake = 0u
        private set

    @SerializedName("username")
    lateinit var username: String
        private set

    @SerializedName("discriminator")
    var discriminator: Discriminator = 0
        private set

    @SerializedName("avatar")
    var avatar: Hash? = null
        private set

    @SerializedName("bot")
    var bot: Boolean? = null
        private set

    @SerializedName("system")
    var system: Boolean? = null
        private set

    @SerializedName("locale")
    var locale: String? = null
        private set

    @SerializedName("verified")
    var verified: Boolean? = null
        private set

    @SerializedName("email")
    var email: String? = null
        private set

    @SerializedName("flags")
    var flags: Int? = null
        private set

    @SerializedName("premium_type")
    var premiumType: PremiumType? = null
        private set

    @SerializedName("public_flags")
    var publicFlags: Int? = null
        private set
    
    fun hasFlag(flag: UserFlag) = ((publicFlags ?: 0) and flag.value) == flag.value
}
