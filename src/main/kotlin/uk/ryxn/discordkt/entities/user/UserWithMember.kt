package uk.ryxn.discordkt.entities.user

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.guild.member.Member
import uk.ryxn.discordkt.gateway.Shard

class UserWithMember(
    shard: Shard,

    @SerializedName("member")
    val member: Member
) : User(shard)