package uk.ryxn.discordkt.utils

import kotlinx.coroutines.runBlocking
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

// wraps a ReentrantReadWriteLock to be coroutine safe
class RWMutex(fair: Boolean = false) {
    private val mutex = ReentrantReadWriteLock(fair)

    fun <T> read(action: () -> T) = runBlocking {
        mutex.read(action)
    }

    fun <T> readSuspending(action: suspend () -> T) = runBlocking {
        mutex.read {
            action()
        }
    }

    fun <T> write(action: () -> T) = runBlocking {
        mutex.write(action)
    }

    fun <T> writeSuspending(action: suspend () -> T) = runBlocking {
        mutex.write {
            action()
        }
    }
}