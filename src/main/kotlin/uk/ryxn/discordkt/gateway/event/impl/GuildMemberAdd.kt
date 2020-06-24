package uk.ryxn.discordkt.gateway.event.impl

import uk.ryxn.discordkt.entities.guild.member.MemberWithGuild
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class GuildMemberAdd(
    val member: MemberWithGuild
) : Event {
    companion object : CustomDeserializer<GuildMemberAdd>() {
        override val deserializer = createDeserializer { json, type, ctx ->
            GuildMemberAdd(ctx.deserialize(json, type))
        }
    }
}
