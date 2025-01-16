package com.example.android_related.practices

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.android_related.MainTag

class MyReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(MainTag + "MyReceiver", "onReceive")
    }
}

sealed class Result {
    abstract fun printResult()
    open fun getResult(){}
    class Success: Result(){
        override fun printResult() {
            println("=== Success ===")
        }
        override fun getResult(){

        }
    }
    class Failure: Result() {
        override fun printResult() {
            println("=== Failure ===")
        }

    }
    class Loading: Result() {
        override fun printResult() {
            println("=== Loading ===")
        }
    }
}