package uk.ryxn.discordkt.entities

import uk.ryxn.discordkt.gateway.Shard

open class Entity(
    @Transient
    open val shard: Shard
)