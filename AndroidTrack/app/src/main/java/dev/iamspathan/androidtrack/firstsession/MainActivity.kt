package dev.iamspathan.androidtrack.firstsession

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import dev.iamspathan.androidtrack.R.id
import dev.iamspathan.androidtrack.R.layout

class MainActivity : AppCompatActivity() {


    private val TAG = "FirstActivityState"

    lateinit var button:Button

    private var isLogin = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        button = findViewById(id.nextButton)

        button.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        Log.d(TAG, "OnCreate")
    }


    fun checkStatus(isLogin:Boolean){
        if (isLogin){
            Toast.makeText(this, "User Logged In", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "User Logged Out", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart")

       checkStatus(isLogin)

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop")
        isLogin = false
        checkStatus(isLogin)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "OnRestart")
    }




}