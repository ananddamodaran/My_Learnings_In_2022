package dev.damodaran.testworkmanager

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class TestWorkManagerApp : Application(){
    override fun onCreate() {
        super.onCreate()

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel("download_channel","file_download",NotificationManager.IMPORTANCE_HIGH)

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(notificationChannel)


        }
    }
}