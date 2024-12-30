package com.example.android_related

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.android_related.start_type.CustomSystemHandler

class MyApplication: Application() {
    private val TAG = "MyApplication"
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.i(MainTag + TAG, "attachBaseContext")
        CustomSystemHandler.hookSystemHandler()
    }
}