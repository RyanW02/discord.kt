package uk.ryxn.discordkt.core.http.endpoint

import io.ktor.client.utils.EmptyContent
import io.ktor.http.*
import uk.ryxn.discordkt.Constants
import uk.ryxn.discordkt.core.ratelimiter.buckets
import uk.ryxn.discordkt.entities.Snowflake

abstract class Endpoint(
    val endpoint: String,
    val majorParameter: Snowflake,
    val type: HttpMethod,
    val contentType: ContentType?,
    val body: Any = EmptyContent
) {
    fun buildUrl() = URLBuilder(Constants.BASE_URL + endpoint).build()

    fun getRateLimitParameter() = buckets[this::class.java] ?: majorParameter
}
