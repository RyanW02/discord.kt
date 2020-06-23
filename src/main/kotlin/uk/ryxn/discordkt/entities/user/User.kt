package uk.ryxn.discordkt.entities.user

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Avatar
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

class User(
    shard: Shard
): Entity(shard) {
    @SerializedName("id")
    var id: Snowflake = 0u

    @SerializedName("username")
    lateinit var username: String

    @SerializedName("discriminator")
    var discriminator: Discriminator = 0

    @SerializedName("avatar")
    var avatar: Avatar? = null

    @SerializedName("bot")
    var bot: Boolean = false

    @SerializedName("system")
    var system: Boolean = false

    @SerializedName("locale")
    var locale: String = ""

    @SerializedName("verified")
    var verified: Boolean = false

    @SerializedName("email")
    var email: String? = null

    @SerializedName("flags")
    var flags: Int = 0

    @SerializedName("premium_type")
    var premiumType: PremiumType = PremiumType.NONE

    @SerializedName("public_flags")
    var publicFlags: Int = 0

    fun hasFlag(flag: UserFlag) = (publicFlags and flag.value) == flag.value
}
