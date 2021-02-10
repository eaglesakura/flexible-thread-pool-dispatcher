package io.github.eaglesakura.flexible_thread_pool_dispatcher

import java.util.concurrent.TimeUnit
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher

/**
 * Dispatcher with flexible thread pool.
 *
 * Thread pools are auto scale by ThreadPoolExecutor.
 * When do not using this instance in coroutines, Thread will be shutdown by a Dalvik.
 *
 * e.g.)
 *
 * val dispatcher = FlexibleThreadPoolDispatcher.newDispatcher(4, 1, TimeUnit.SECONDS)  // 4thread, 1seconds auto-scale dispatcher.
 *
 * @author @eaglesakura
 * @link https://github.com/eaglesakura/flexible-thread-pool-dispatcher
 */
@Suppress("MemberVisibilityCanBePrivate")
object FlexibleThreadPoolDispatcher {

    /**
     * Returns new auto-scale coroutine dispatcher.
     */
    fun newDispatcher(
        maxThreads: Int,
        keepAliveTime: Long,
        keepAliveTimeUnit: TimeUnit
    ): CoroutineDispatcher {
        return FlexibleThreadPoolExecutor(
            maxThreads,
            keepAliveTime,
            keepAliveTimeUnit
        ).asCoroutineDispatcher()
    }

    /**
     * for Device input/output dispatcher.
     */
    @Deprecated("compat, will remove this property.")
    val IO: CoroutineDispatcher by lazy {
        newDispatcher(
            Runtime.getRuntime().availableProcessors() * 2 + 1,
            5,
            TimeUnit.SECONDS
        )
    }

    /**
     * for Network fetch dispatcher.
     */
    @Deprecated("compat, will remove this property.")
    val Network: CoroutineDispatcher by lazy {
        newDispatcher(
            Runtime.getRuntime().availableProcessors() * 2 + 1,
            5,
            TimeUnit.SECONDS
        )
    }
}
