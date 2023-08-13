package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val appTag: String = "TestApp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button)
            .setOnClickListener {
                exportDebugLog("ButtonClicked!!!")
                exportInformationLog("ButtonClicked!")
            }
        exportDebugLog("OnCreate")
    }

    private fun exportDebugLog(message :String){
        Log.d(appTag, message)
    }

    private fun exportInformationLog(message: String){
        Log.i(appTag, message)
    }
}