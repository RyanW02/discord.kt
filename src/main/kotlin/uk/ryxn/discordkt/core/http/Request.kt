package uk.ryxn.discordkt.core.http

import io.ktor.client.call.receive
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import io.ktor.http.contentType
import io.ktor.util.filter
import io.ktor.util.toMap
import kotlinx.coroutines.runBlocking
import uk.ryxn.discordkt.core.http.endpoint.Endpoint
import uk.ryxn.discordkt.core.http.endpoint.Parameter
import uk.ryxn.discordkt.core.ratelimiter.buckets
import uk.ryxn.discordkt.gateway.Shard
import kotlin.math.roundToLong

class Request(
    val shard: Shard,
    val endpoint: Endpoint
) {
    suspend inline fun <reified T> doRequest(): T {
        shard.rateLimiter().executeCall(endpoint)

        val res = shard.httpClient.request<HttpResponse> {
            url(endpoint.buildUrl())
            method = endpoint.type
            endpoint.contentType?.let(::contentType)

            header("Authorization", "Bot ${shard.options.token}")
            header("X-RateLimit-Precision", "millisecond")

            body = endpoint.body
        }

        val bucket = res.headers["X-RateLimit-Bucket"]
        if (bucket != null) {
            buckets[Endpoint::class.java] = bucket
        }

        if (res.headers["X-RateLimit-Global"]?.toBoolean() == true) {
            shard.rateLimiter().updateGlobalRateLimit(res.headers["Retry-After"]?.toLongOrNull() ?: 0)
        }

        val remaining = res.headers["X-RateLimit-Remaining"]?.toIntOrNull()
        val resetAfter = res.headers["X-RateLimit-Reset-After"]?.toDoubleOrNull()?.times(1000)?.roundToLong()

        if (remaining != null && resetAfter != null) {
            shard.rateLimiter().updateRateLimit(endpoint, remaining, resetAfter)
        }

        return res.receive()
    }
}