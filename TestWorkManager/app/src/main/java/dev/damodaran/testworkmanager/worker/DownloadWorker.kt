package dev.damodaran.testworkmanager.worker

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.startForegroundService
import androidx.core.net.toUri
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import dev.damodaran.testworkmanager.R
import dev.damodaran.testworkmanager.api.FileApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

@Suppress("BlockingMethodInNonBlockingContext")
class DownloadWorker(
    private val context: Context,
    private val workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        startForegroundService()
        delay(10000L)

        val response = FileApi.instance.downloadImage()
        response.body()?.let { body ->
            return withContext(Dispatchers.IO) {
                val file = File(context.cacheDir, "car_image.jpg")

                val outputStream = FileOutputStream(file)

                outputStream.use { stream ->
                    try {
                        stream.write(body.bytes())
                    } catch (ex: IOException) {
                        return@withContext Result.failure(
                            workDataOf(WorkerKeys.ERROR_MSG to ex.localizedMessage)
                        )
                    }

                }
                Result.success(
                    workDataOf(
                        WorkerKeys.IMAGE_URI to file.toUri().toString()
                    )
                )
            }


        }
        if(!response.isSuccessful){
            if(response.code().toString().startsWith("5")){
                return Result.retry()
            }
            return Result.failure(workDataOf(
                WorkerKeys.ERROR_MSG to "Unknown error"
            ))
        }
        return Result.failure(workDataOf(WorkerKeys.ERROR_MSG to "Unknown error"))

}



    private suspend fun startForegroundService() {
        setForeground(
            ForegroundInfo(
                Random().nextInt(),
                NotificationCompat.Builder(context, "download_channel")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText("Downloading...")
                    .setContentTitle("Download in progress")
                    .build()
            )
        )
    }
}