package com.example.android_related.common

import android.app.Application
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Choreographer
import com.example.android_related.MainTag

object FpsMonitor {
    private const val FPS_INTERVAL_TIME = 1000L

    /**
     * 1秒执行回调的次数，即fps
     * */
    private var count = 0;
    private val mMonitorListeners = mutableListOf<(Int) -> Unit>()

    @Volatile
    private var isStartMonitor = false
    private val monitorFrameCallback by lazy {
        MonitorFrameCallback()
    }
    private val mainHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    fun startMonitor(listener: (Int) -> Unit) {
        mMonitorListeners.add(listener)
        if (isStartMonitor) {
            return
        }
        isStartMonitor = true
        Choreographer.getInstance().postFrameCallback(monitorFrameCallback)
        mainHandler.postDelayed(monitorFrameCallback, 1000L)
    }

    class MonitorFrameCallback: Choreographer.FrameCallback, Runnable {

        override fun doFrame(frameTimeNanos: Long) {
            // 监控FPS
            count++
            Choreographer.getInstance().postFrameCallback(this)

            //监控是否掉帧，卡顿

        }

        override fun run() {
            mMonitorListeners.forEach {
                it.invoke(count)
            }
            count = 0
            mainHandler.postDelayed(monitorFrameCallback, 1000L)
        }

    }
}
