package dev.anand.fileupload

import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import java.io.File
import java.io.IOException

class FileRepository {
    suspend fun uploadImage(file: File): Boolean {
        return try {
            FileApi.instance.uploadImage(
                image = MultipartBody.Part.createFormData(
                    "image", file.name, file.asRequestBody()
                )
            )
            true
        } catch (ex: IOException) {
            ex.printStackTrace()
            false
        } catch (ex: HttpException) {
            ex.printStackTrace()
            false
        }
    }
}