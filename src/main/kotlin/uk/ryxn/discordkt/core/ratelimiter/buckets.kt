package uk.ryxn.discordkt.core.ratelimiter

import uk.ryxn.discordkt.core.http.endpoint.Endpoint
import java.util.concurrent.ConcurrentHashMap

val buckets = ConcurrentHashMap<Class<Endpoint>, String>()