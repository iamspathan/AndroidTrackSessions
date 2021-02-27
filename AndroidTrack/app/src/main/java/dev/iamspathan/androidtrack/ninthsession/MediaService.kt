package dev.iamspathan.androidtrack.ninthsession

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import dev.iamspathan.androidtrack.R

class MediaService : Service() {

    val TAG = "MediaService"

    lateinit var mediaPlayer : MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        mediaPlayer = MediaPlayer.create(this, R.raw.sample)
        mediaPlayer.isLooping = false

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start()

        intent?.getStringExtra("MESSAGE").let {
            Log.d(TAG , it!!)
        }
        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }


}