package dev.damodaran.testcompose.mvvm_vt.app

import android.app.Application
import androidx.room.Room
import dev.damodaran.testcompose.mvvm_vt.room.CreatureDatabase

//https://github.com/raywenderlich/vt_android_mvvm/tree/master/v1/for_student/recording

class CreatureApplication:Application() {
    companion object {
        lateinit var database: CreatureDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, CreatureDatabase::class.java, "creature_database")
            .build()
    }
}