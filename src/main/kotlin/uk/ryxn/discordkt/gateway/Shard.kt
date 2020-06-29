package uk.ryxn.discordkt.gateway

import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.websocket.ClientWebSocketSession
import io.ktor.client.features.websocket.DefaultClientWebSocketSession
import io.ktor.client.features.websocket.WebSockets
import io.ktor.client.features.websocket.webSocketSession
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.close
import io.ktor.http.cio.websocket.readText
import io.ktor.util.KtorExperimentalAPI
import kotlinx.coroutines.*
import uk.ryxn.discordkt.Constants
import uk.ryxn.discordkt.core.gsonBuilder
import uk.ryxn.discordkt.core.http.KtorGsonClient
import uk.ryxn.discordkt.core.withEntityAdapters
import uk.ryxn.discordkt.core.withEventAdapters
import uk.ryxn.discordkt.core.withPayloadAdapters
import uk.ryxn.discordkt.entities.user.presence.UpdateStatus
import uk.ryxn.discordkt.gateway.payload.PayloadData
import uk.ryxn.discordkt.gateway.payload.Payload
import uk.ryxn.discordkt.gateway.payload.impl.*
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.atomic.AtomicReference

class Shard(val shardManager: ShardManager, options: ShardOptions.() -> Unit) {

    val options = ShardOptions().also(options)

    internal val gson = gsonBuilder
        .withEntityAdapters(this)
        .withPayloadAdapters(this)
        .withEventAdapters()
        .create()

    val httpClient = HttpClient(CIO) {
        install(WebSockets)
        install(JsonFeature) {
            serializer = KtorGsonClient(gson)
        }
    }

    private var state = AtomicReference<State>(State.DEAD)

    // consider -1 as null
    private val seq = AtomicInteger(-1)

    internal val sessionId = AtomicReference<String>("")
    fun canResume() = sessionId.get() != ""

    var _ws: DefaultClientWebSocketSession? = null
    val wsContext = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    suspend fun connect() {
        // make sure shard is not already connected
        if (state.get() != State.DEAD) {
            kill()
        }

        state.set(State.CONNECTING)

        shardManager.botOptions.rateLimiter.identifyWait(options.shardId)

        // connect websocket
        withContext(wsContext) {
            _ws = httpClient.webSocketSession {
                url(Constants.GATEWAY)
                method = HttpMethod.Get
            }
        }
        _ws?.closeReason?.invokeOnCompletion { println(_ws?.closeReason?.getCompleted()) }

        // recv hello & start heartbeating
        val hello = readPayload() as Hello
        startHeartbeatLoop(hello.data.heartbeatInterval)

        // authenticate
        // check if we can resume first
        if (canResume()) {
            resume()
        } else {
            // identify ourselves to discord
            val identify = Identify.create(
                this, Identify.Data(
                    token = options.token,
                    shard = ShardData(options.shardId, options.totalShards),
                    presence = options.status
                )
            )
            identify.write()
        }

        while (true) {
            val payload = readPayload()
            payload.handle(this)
        }
    }

    private suspend fun resume() {
        val payload = Resume.create(this, Resume.Data(token = options.token, sessionId = sessionId.get(), sequenceNumber = seq.get()))
        payload.write()
    }

    private suspend fun ClientWebSocketSession.readRaw(): String {
        val payload = incoming.receive() as Frame.Text
        return payload.readText()
    }

    // safe as in no race condition
    // we assume the websocket is not null
    private suspend fun readSafe() = withContext(wsContext) {
        _ws!!.readRaw()
    }

    private suspend fun readPayload(): Payload {
        val json = gson.fromJson<JsonObject>(readSafe(), JsonObject::class.java)
        println(json)

        // find opcode so we can get the payload's class
        val opcode = PayloadData.get(json.get("op").asInt)

        // update sequence number
        if (!json.get("s").isJsonNull) {
            json.get("s")?.asInt?.let { s ->
                seq.set(s)
            }
        }

        return gson.fromJson(json, opcode.clazz)
    }

    private suspend fun ClientWebSocketSession.write(payload: Payload) {
        // encode
        val json = gson.toJson(payload)
        send(Frame.Text(json))
    }

    private suspend fun writeSafe(payload: Payload) = withContext(wsContext) {
        _ws!!.write(payload)
    }

    private suspend fun Payload.write() = writeSafe(this)

    private var heartbeatLoop: Job? = null
    private val heartbeatContext = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    internal val lastAck = AtomicLong(System.currentTimeMillis())

    private suspend fun startHeartbeatLoop(interval: Long) {
        withContext(heartbeatContext) {
            heartbeatLoop = GlobalScope.launch {
                while (true) {
                    delay(interval)
                    doHeartbeat(interval)
                }
            }
        }
    }

    private suspend fun doHeartbeat(interval: Long) {
        // check if we have received a heartbeat ack
        if (System.currentTimeMillis() - lastAck.get() > interval) {
            kill()
            connect()
            return
        }

        var s: Int? = seq.get()
        if (s == -1) {
            s = null
        }

        Heartbeat.create(this, s).write()
    }

    suspend fun kill() {
        println("killing")
        state.set(State.DISCONNECTING)

        withContext(heartbeatContext) {
            heartbeatLoop?.cancel()
            heartbeatLoop = null
        }

        withContext(wsContext) {
            _ws?.close()
            _ws = null
        }

        state.set(State.DEAD)
    }

    suspend fun updateStatus(data: UpdateStatus) {
        val payload = PresenceUpdate.create(this, data)
        payload.write()
    }

    suspend fun requestGuildMembers(data: RequestGuildMembers.Data) {
        val payload = RequestGuildMembers.create(this, data)
        payload.write()
    }

    suspend fun updateVoiceState(data: UpdateVoiceState.Data) {
        val payload = UpdateVoiceState.create(this, data)
        payload.write()
    }

    fun rateLimiter() = shardManager.botOptions.rateLimiter
}