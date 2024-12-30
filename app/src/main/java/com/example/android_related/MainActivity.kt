package com.example.android_related

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_related.common.FpsMonitor
import com.example.android_related.practices.MyService
const val MainTag = "Test."
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.i(MainTag + TAG, "onCreate")
        val intent = Intent(baseContext, MyService::class.java)
        startService(intent)
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
        FpsMonitor.startMonitor { counts ->
            Log.i(MainTag + TAG, "fPS:$counts")
        }
    }
}