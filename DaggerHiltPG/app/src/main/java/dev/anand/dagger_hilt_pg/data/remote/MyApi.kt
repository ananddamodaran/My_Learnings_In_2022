package dev.anand.dagger_hilt_pg.data.remote

import retrofit2.http.GET

interface MyApi {
    @GET("testCall")
    suspend fun doNetworkCall()
}