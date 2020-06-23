package uk.ryxn.discordkt.gateway

import com.google.gson.JsonObject
import io.ktor.client.features.websocket.ClientWebSocketSession
import io.ktor.client.features.websocket.DefaultClientWebSocketSession
import io.ktor.client.features.websocket.webSocketSession
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.readText
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import uk.ryxn.discordkt.Constants
import uk.ryxn.discordkt.core.gsonBuilder
import uk.ryxn.discordkt.core.withEntityAdapters
import uk.ryxn.discordkt.gateway.payload.PayloadData
import uk.ryxn.discordkt.gateway.payload.Payload
import uk.ryxn.discordkt.gateway.payload.impl.Heartbeat
import uk.ryxn.discordkt.gateway.payload.impl.Hello
import uk.ryxn.discordkt.gateway.payload.impl.Identify
import uk.ryxn.discordkt.http.client
import uk.ryxn.discordkt.utils.RWMutex

class Shard(options: ShardOptions.() -> Unit) {

    private val options = ShardOptions().also(options)

    val gson = gsonBuilder
        .withEntityAdapters(this)
        .create()

    private var state = State.DEAD
    private val stateMutex = Mutex()

    private var seq: Int? = null
    private var seqLock = RWMutex(true)

    var _ws: DefaultClientWebSocketSession? = null
    val _wsMutex = RWMutex(true)

    suspend fun connect() {
        // update state
        stateMutex.lock()

        // make sure shard is not already connected
        if (state != State.DEAD) {
            stateMutex.unlock()
            kill()
            stateMutex.lock()
        }

        state = State.CONNECTING
        stateMutex.unlock()

        // connect websocket
        _wsMutex.writeSuspending {
            _ws = client.webSocketSession {
                url(Constants.GATEWAY)
                method = HttpMethod.Get
            }
        }

        // recv hello & start heartbeating
        val hello = readPayload() as Hello
        startHeartbeatLoop(hello.data.heartbeatInterval)

        // identify ourselves to discord
        val identify = Identify.create(Identify.Data(
            token = options.token,
            shard = ShardData(0, 1)
        ))
        identify.write()

        while (true) {
            println(readPayload())
        }
    }

    private suspend fun ClientWebSocketSession.readRaw(): String {
        val payload = incoming.receive() as Frame.Text
        return payload.readText()
    }

    // safe as in no race condition
    // we assume the websocket is not null
    private fun readSafe() = _wsMutex.readSuspending {
        _ws!!.readRaw()
    }

    private fun readPayload(): Payload {
        val json = gson.fromJson<JsonObject>(readSafe(), JsonObject::class.java)
        println(json)

        // find opcode so we can get the payload's class
        val opcode = PayloadData.get(json.get("op").asInt)

        // update sequence number
        if (!json.get("s").isJsonNull) {
            json.get("s")?.asInt?.let { s ->
                seqLock.write {
                    seq = s
                }
            }
        }

        return gson.fromJson(json, opcode.clazz)
    }

    private suspend fun ClientWebSocketSession.write(payload: Payload) {
        // encode
        val json = gson.toJson(payload)
        println(json)
        send(Frame.Text(json))
    }

    private fun writeSafe(payload: Payload) = _wsMutex.readSuspending {
        _ws!!.write(payload)
    }

    private fun Payload.write() = writeSafe(this)

    private var heartbeatLoop: Job? = null
    private val heartbeatMutex = Mutex()

    private suspend fun startHeartbeatLoop(interval: Long) {
        heartbeatMutex.withLock {
            heartbeatLoop = GlobalScope.launch {
                delay(interval)
                doHeartbeat()
            }
        }
    }

    private fun doHeartbeat() {
        var s: Int? = null
        seqLock.read {
            s = seq
        }

        Heartbeat.create(s).write()
    }

    fun kill() {

    }
}