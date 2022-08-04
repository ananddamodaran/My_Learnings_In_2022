package dev.anand.localnotification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        createLocalNotificationChannel()
    }

    private fun createLocalNotificationChannel() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                LocalCounterNotificationService.COUNTER_CHANNEL_ID,
                "Counter",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "Used for the increment counter notification"

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as
                     NotificationManager

            notificationManager.createNotificationChannel(channel)


        }
    }
}