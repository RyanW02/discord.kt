package uk.ryxn.discordkt.core.http.endpoint

import io.ktor.http.HttpMethod
import uk.ryxn.discordkt.entities.Snowflake

abstract class GetEndpoint(
    endpoint: String,
    majorParameter: Snowflake
) : Endpoint(endpoint, majorParameter, HttpMethod.Get, null)
