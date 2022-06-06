package dev.damodaran.testworkmanager.api

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface FileApi {
    @GET("/img/car.jpg")
    suspend fun downloadImage():Response<ResponseBody>

    companion object {
        val instance: FileApi by lazy{
            Retrofit.Builder()
                .baseUrl("https://damodaran.dev")
                .build()
                .create(FileApi::class.java)
        }
    }
}