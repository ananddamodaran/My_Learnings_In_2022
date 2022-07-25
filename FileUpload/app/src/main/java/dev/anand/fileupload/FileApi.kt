package dev.anand.fileupload

import okhttp3.MultipartBody
import retrofit2.Retrofit
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface FileApi {
    @Multipart
    @POST("/file")
    suspend fun uploadImage(@Part image: MultipartBody.Part)

    companion object {
        val instance by lazy {
            Retrofit.Builder().baseUrl("http://192.168.29.224:8080/").build()
                .create(FileApi::class.java)
        }
    }
}
