package dev.iamspathan.androidtrack.eighthsession

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import dev.iamspathan.androidtrack.R
import dev.iamspathan.androidtrack.databinding.ActivityNotificationBinding
import dev.iamspathan.androidtrack.seventhsession.RecyclerViewActivity

class NotificationActivity : AppCompatActivity() {

    val NOTIFICATION_CHANNEL_ID = "Demo Notification"
    val NOTIFICATION_CHANNEL_NAME = "Android Track Notification"
    val NOTIFICATION_CHANNEL_DESCRIPTION = "This is demo description"
    lateinit var notificationManager: NotificationManager

    lateinit var  binding : ActivityNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel()

        binding.buttonNotify.setOnClickListener {
            createNotification()
        }

    }


    fun createNotificationChannel(){
        // If my app is running greater than the version of Oreo, then
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){

            val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH).apply {
                description = NOTIFICATION_CHANNEL_DESCRIPTION
            }
            notificationManager.createNotificationChannel(channel)

        }
    }


    fun createNotification(){

        val intent = Intent(this, RecyclerViewActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(this,0, intent, 0)


        val builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.snapchat)
            .setContentTitle("You have received the message")
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setContentText("This is demo Description")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(101, builder)
    }







}