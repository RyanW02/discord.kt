package uk.ryxn.discordkt.core.http.endpoint

import io.ktor.client.utils.EmptyContent
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import uk.ryxn.discordkt.entities.Snowflake

abstract class PostEndpoint(
    endpoint: String,
    majorParameter: Snowflake,
    contentType: ContentType,
    body: Any = EmptyContent
) : Endpoint(endpoint, majorParameter, HttpMethod.Post, contentType, body)
