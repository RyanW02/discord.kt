package uk.ryxn.discordkt.entities

import uk.ryxn.discordkt.gateway.Shard

open class Entity(
    @Transient
    open var shard: Shard
)