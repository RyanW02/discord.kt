package uk.ryxn.discordkt.core.http.endpoint.impl.guild

import uk.ryxn.discordkt.core.http.endpoint.GetEndpoint
import uk.ryxn.discordkt.entities.Snowflake

class GetGuildInvites(val guildId: Snowflake) : GetEndpoint("/guilds/$guildId/invites", guildId)