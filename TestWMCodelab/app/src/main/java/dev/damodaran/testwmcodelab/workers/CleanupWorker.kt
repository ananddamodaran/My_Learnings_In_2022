package dev.damodaran.testwmcodelab.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dev.damodaran.testwmcodelab.utils.DELAY_TIME_MILLIS
import dev.damodaran.testwmcodelab.utils.OUTPUT_PATH
import kotlinx.coroutines.delay
import java.io.File

private const val TAG = "CleanupWorker"
class CleanupWorker(
    context: Context,
    workParams: WorkerParameters): CoroutineWorker(context,workParams) {
    override suspend fun doWork(): Result {
        makeStatusNotification("Cleaning up old temporary files", applicationContext)
        delay(DELAY_TIME_MILLIS)
        return try {
            val outputDirectory = File(applicationContext.filesDir, OUTPUT_PATH)
            if (outputDirectory.exists()) {
                val entries = outputDirectory.listFiles()
                if (entries != null) {
                    for (entry in entries) {
                        val name = entry.name
                        if (name.isNotEmpty() && name.endsWith(".png")) {
                            val deleted = entry.delete()
                            Log.i(TAG, "Deleted $name - $deleted")
                        }
                    }
                }
            }
            Result.success()
        } catch (exception: Exception) {
            exception.printStackTrace()
            Result.failure()
        }
    }
}