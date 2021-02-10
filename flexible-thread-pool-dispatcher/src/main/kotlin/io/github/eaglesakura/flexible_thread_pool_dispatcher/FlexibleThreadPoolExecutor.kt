package io.github.eaglesakura.flexible_thread_pool_dispatcher

import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

internal class FlexibleThreadPoolExecutor(
    maxThreads: Int,
    keepAliveTime: Long,
    keepAliveTimeUnit: TimeUnit
) : ThreadPoolExecutor(0, maxThreads, keepAliveTime, keepAliveTimeUnit, LinkedBlockingDeque()) {
    override fun execute(command: Runnable?) {
        try {
            corePoolSize = maximumPoolSize
            super.execute(command)
        } finally {
            corePoolSize = 0
        }
    }
}
