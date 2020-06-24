package uk.ryxn.discordkt.entities.user

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Hash
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

class User(
    @Transient
    override var shard: Shard,

    @SerializedName("id")
    val id: Snowflake,

    @SerializedName("username")
    val username: String,

    @SerializedName("discriminator")
    val discriminator: Discriminator,

    @SerializedName("avatar")
    val avatar: Hash?,

    @SerializedName("bot")
    val bot: Boolean,

    @SerializedName("system")
    val system: Boolean,

    @SerializedName("locale")
    val locale: String,

    @SerializedName("verified")
    val verified: Boolean,

    @SerializedName("email")
    val email: String?,

    @SerializedName("flags")
    val flags: Int,

    @SerializedName("premium_type")
    val premiumType: PremiumType,

    @SerializedName("public_flags")
    val publicFlags: Int
) : Entity(shard) {
    fun hasFlag(flag: UserFlag) = (publicFlags and flag.value) == flag.value
}
