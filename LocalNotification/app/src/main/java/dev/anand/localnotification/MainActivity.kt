package dev.anand.localnotification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.anand.localnotification.ui.theme.LocalNotificationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = LocalCounterNotificationService(context = applicationContext)
        setContent {
            LocalNotificationTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Button(
                        onClick = { service.showNotification(Counter.value) },
                        modifier = Modifier.align(
                            Alignment.Center
                        )
                    ) {
                        Text(text = "Show Notification")
                    }
                }
            }
        }
    }
}

