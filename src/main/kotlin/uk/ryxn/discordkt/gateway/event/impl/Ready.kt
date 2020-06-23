package uk.ryxn.discordkt.gateway.event.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.event.Event

class Ready : Event {
    @SerializedName("v")
    var version: Int = 0

    @SerializedName("user")
    lateinit var user: User

    @SerializedName("private_channels")
    var privateChannels: Array<Channel> = emptyArray() // always empty
}