package dev.anand.localnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class LocalCounterBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val service = LocalCounterNotificationService(context)
        service.showNotification(++Counter.value)


    }
}