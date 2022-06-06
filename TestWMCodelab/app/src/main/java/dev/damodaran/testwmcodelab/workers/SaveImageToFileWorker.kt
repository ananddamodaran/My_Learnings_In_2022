package dev.damodaran.testwmcodelab.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.icu.text.CaseMap

import java.text.SimpleDateFormat

import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import dev.damodaran.testwmcodelab.utils.DELAY_TIME_MILLIS
import dev.damodaran.testwmcodelab.utils.KEY_IMAGE_URI
import kotlinx.coroutines.delay
import java.util.*

private const val TAG = "SaveImageToFileWorker"
class SaveImageToFileWorker(context: Context,
    workParams: WorkerParameters
                            ) : CoroutineWorker(context,workParams){

    private val Title = "Blurred Image"
    private val dateFormatter = SimpleDateFormat(
        "yyyy.MM.dd 'at' HH:mm:ss z",
        Locale.getDefault()
    )
    override suspend fun doWork(): Result {
        makeStatusNotification("Saving image", applicationContext)
        delay(DELAY_TIME_MILLIS)
        val resolver = applicationContext.contentResolver

        return try {
            val resourceUri = inputData.getString(KEY_IMAGE_URI)
            val bitmap = BitmapFactory.decodeStream(
                resolver.openInputStream(Uri.parse(resourceUri)))
            val imageUrl = MediaStore.Images.Media.insertImage(
                resolver, bitmap, Title, dateFormatter.format(Date()))
            if (!imageUrl.isNullOrEmpty()) {
                val output = workDataOf(KEY_IMAGE_URI to imageUrl)

                Result.success(output)
            } else {
                Log.e(TAG, "Writing to MediaStore failed")
                Result.failure()
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            Result.failure()
        }

    }
}