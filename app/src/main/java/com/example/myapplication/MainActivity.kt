package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val appTag: String = "TestApp"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button)
            .setOnClickListener {
                exportDebugLog("ButtonClicked!!!")
                exportInformationLog("ButtonClicked!")
                buttonTapEvent()
            }
        exportDebugLog("OnCreate")
    }

    private fun exportDebugLog(message :String){
        Log.d(appTag, message)
    }

    private fun exportInformationLog(message: String){
        Log.i(appTag, message)
    }

    private fun buttonTapEvent(){
        val textView = findViewById<TextView>(R.id.text)

        val queue = Volley.newRequestQueue(this)
        val url = "http://10.0.2.2:3000"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                exportDebugLog("Success!")
                val json = JSONObject(response.toString())
                exportDebugLog(json.getString("message"))
                textView.text = "Response is: ${json.getString("message")}"
            },
            Response.ErrorListener {
                Log.e(appTag,"Connection Error")
                textView.text = "That didn't work!"
            })

        queue.add(stringRequest)
    }
}