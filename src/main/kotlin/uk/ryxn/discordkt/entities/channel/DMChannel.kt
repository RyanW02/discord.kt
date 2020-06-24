package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.Shard

open class DMChannel(shard: Shard) : TextChannel(shard) {
    @SerializedName("recipients")
    var recipients: Array<User> = emptyArray()
}