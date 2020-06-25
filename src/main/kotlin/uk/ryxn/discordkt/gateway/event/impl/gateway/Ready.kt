package uk.ryxn.discordkt.gateway.event.impl.gateway

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.entities.guild.UnavailableGuild
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.ShardData
import uk.ryxn.discordkt.gateway.event.Event

class Ready(
    @SerializedName("v")
    val version: Int,

    @SerializedName("user")
    val user: User,

    @SerializedName("private_channels")
    val privateChannels: Array<Channel>, // always empty

    @SerializedName("guilds")
    val guilds: Array<UnavailableGuild>,

    @SerializedName("session_id")
    val sessionId: String,

    @SerializedName("shard")
    val shard: ShardData
) : Event