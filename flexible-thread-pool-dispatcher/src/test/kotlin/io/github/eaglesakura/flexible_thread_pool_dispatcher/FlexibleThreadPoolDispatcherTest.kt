package io.github.eaglesakura.flexible_thread_pool_dispatcher

import java.util.concurrent.TimeUnit
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Test

class FlexibleThreadPoolDispatcherTest {

    @Test
    fun launch_success() = runBlocking {
        val dispatcher = FlexibleThreadPoolDispatcher.newDispatcher(5, 10, TimeUnit.MILLISECONDS)

        withContext(dispatcher) {
            delay(10)
            println("dispatch success")
        }
    }

    @Test
    fun launch_success_with_current() = runBlocking {
        val dispatcher = FlexibleThreadPoolDispatcher.newDispatcher(5, 10, TimeUnit.MILLISECONDS)

        withContext(coroutineContext + dispatcher) {
            delay(10)
            println("dispatch success")
        }
    }
}
