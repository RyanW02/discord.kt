package uk.ryxn.discordkt.http

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.websocket.WebSockets

// we should share 1 client throughout the whole application
val client = HttpClient(CIO) {
    install(WebSockets)
}