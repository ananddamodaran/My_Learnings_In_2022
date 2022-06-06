package dev.damodaran.testcompose.mvvm_vt.room

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import dev.damodaran.testcompose.mvvm_vt.app.CreatureApplication
import dev.damodaran.testcompose.mvvm_vt.model.Creature
import dev.damodaran.testcompose.mvvm_vt.model.CreatureRepository

class RoomRepository : CreatureRepository {
    private val creatureDao: CreatureDao = CreatureApplication.database.creatureDao()
    private val allCreatures: LiveData<List<Creature>>

    init {
        allCreatures = creatureDao.getAllCreatures()
    }

    override fun saveCreature(creature: Creature) {
        InsertAsyncTask(creatureDao).execute(creature)
    }

    override fun getAllCreatures() = allCreatures

    override fun clearAllCreatures() {
        val creatureArray = allCreatures.value?.toTypedArray()
        if (creatureArray != null) {
            DeleteAsyncTask(creatureDao).execute(*creatureArray)
        }
    }

    private class InsertAsyncTask internal constructor(private val dao: CreatureDao) : AsyncTask<Creature, Void, Void>() {
        override fun doInBackground(vararg params: Creature): Void? {
            dao.insert(params[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: CreatureDao) : AsyncTask<Creature, Void, Void>() {
        override fun doInBackground(vararg params: Creature): Void? {
            dao.clearCreatures(*params)
            return null
        }
    }
}