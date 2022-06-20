package dev.anand.dagger_hilt_pg.data.repository

import android.app.Application
import dev.anand.dagger_hilt_pg.R
import dev.anand.dagger_hilt_pg.data.remote.MyApi
import dev.anand.dagger_hilt_pg.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
    private val context: Application
) : MyRepository {
    init {
        val appName = context.getString(R.string.app_name)
        println("Hello app name is $appName")
    }
    override suspend fun doNetworkCall() {
        api.doNetworkCall()
    }
}