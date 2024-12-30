package com.example.android_related.start_type

import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.android_related.MainTag
import java.text.MessageFormat.Field

object CustomSystemHandler {

    fun hookSystemHandler() {
        val activityThreadClass = Class.forName("android.app.ActivityThread")
        val currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread")
        currentActivityThreadMethod.isAccessible = true

        //获取主线程对象
        val activityThread = currentActivityThreadMethod.invoke(null)
        //获取mH
        val mH = activityThreadClass.getDeclaredField("mH")
        mH.isAccessible = true

        val handler = mH.get(activityThread)
        val mCallback = Handler::class.java.getDeclaredField("mCallback")
        mCallback.isAccessible = true
        mCallback.set(handler, ActivityThreadHandlerCallback())
    }

    class ActivityThreadHandlerCallback: Handler.Callback {
        override fun handleMessage(msg: Message): Boolean {
            Log.i(MainTag + "ActivityThreadHandlerCallback", "handleMessage")
            return false
        }

    }
}