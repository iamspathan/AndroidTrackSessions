package dev.iamspathan.androidtrack.ninthsession

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.iamspathan.androidtrack.R
import dev.iamspathan.androidtrack.databinding.ActivityMediaPlayerDemoBinding

class MediaPlayerDemo : AppCompatActivity() {

    lateinit var binding: ActivityMediaPlayerDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaPlayerDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val musicIntent = Intent(this, MediaService::class.java)
        musicIntent.putExtra("MESSAGE", "Hey! I'm the message from Media Player Demo")

        binding.startMusic.setOnClickListener {
            startService(musicIntent)
            binding.logText.text = "SERVICE STARTED"
        }

        binding.stopMusic.setOnClickListener {
            stopService(musicIntent)
            binding.logText.text = "SERVICE STOPPED"
        }


    }




}