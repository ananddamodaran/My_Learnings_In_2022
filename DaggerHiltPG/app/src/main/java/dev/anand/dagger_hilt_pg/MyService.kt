package dev.anand.dagger_hilt_pg

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dev.anand.dagger_hilt_pg.domain.repository.MyRepository
import javax.inject.Inject

class MyService : Service() {
    @Inject
    lateinit var repository: MyRepository

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}