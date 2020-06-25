package uk.ryxn.discordkt.gateway.event.impl.guild

import uk.ryxn.discordkt.entities.guild.member.MemberWithGuild
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.defaultDeserializer

class GuildMemberAdd(
    val member: MemberWithGuild
) : Event {
    companion object : CustomDeserializer<GuildMemberAdd>() {
        override val deserializer = defaultDeserializer<GuildMemberAdd, MemberWithGuild>()
    }
}
