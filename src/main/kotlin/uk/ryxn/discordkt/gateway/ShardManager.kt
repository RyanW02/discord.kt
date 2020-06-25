package uk.ryxn.discordkt.gateway

import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.eventbus.EventHandler
import uk.ryxn.discordkt.gateway.event.eventbus.EventListener
import uk.ryxn.discordkt.gateway.payload.BotOptions
import uk.ryxn.discordkt.utils.hasAnnotation
import uk.ryxn.discordkt.utils.kTypeOf
import uk.ryxn.discordkt.utils.withInstance
import kotlin.reflect.KClassifier
import kotlin.reflect.KFunction
import kotlin.reflect.full.functions
import kotlin.reflect.full.isSubtypeOf

class ShardManager(options: BotOptions.() -> Unit) {

    private val botOptions = BotOptions().also(options)

    private val listeners = mutableMapOf<KFunction<Event>, KClassifier>()

    private val shards = Array(botOptions.highestShard - botOptions.lowestShard) { i ->
        Shard(this) {
            token = botOptions.token
            shardId = botOptions.lowestShard + i
        }
    }

    suspend fun connect() {
        for (shard in shards) {
            shard.connect()
        }
    }

    fun registerListener(vararg listener: EventListener) {
        listener.forEach { listener ->
            listener::class.functions
                .filter { it.hasAnnotation<EventHandler>() }
                .map { it.withInstance(listener) }
                .filter { it.parameters.size == 1 }
                .filter { it.parameters[0].type.isSubtypeOf(kTypeOf<Event>()) }
                .map { it as KFunction<Event> }
                .associateWithTo(listeners) { func -> func.parameters[0].type.classifier!! }
        }
    }

    internal fun executeEvent(event: Event) {
        listeners.filterValues { it == event::class }.forEach { (listener, _) ->
            listener.call(event)
        }
    }
}