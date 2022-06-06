package dev.damodaran.testwmcodelab.viewmodel

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.work.*
import dev.damodaran.testwmcodelab.utils.IMAGE_MANIPULATION_WORK_NAME
import dev.damodaran.testwmcodelab.utils.KEY_IMAGE_URI
import dev.damodaran.testwmcodelab.utils.TAG_OUTPUT
import dev.damodaran.testwmcodelab.workers.BlurWorker
import dev.damodaran.testwmcodelab.workers.CleanupWorker
import dev.damodaran.testwmcodelab.workers.SaveImageToFileWorker
import dev.damodaran.testwmcodelab.R

class BlurViewModel(application:Application) :ViewModel(){
    private val workManager = WorkManager.getInstance(application)
    private var imageUri: Uri? = null
    init {

        imageUri = getImageUri(application.applicationContext)
    }
    private fun getImageUri(context: Context): Uri {
        val resources = context.resources

        return Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .authority(resources.getResourcePackageName(R.drawable.android_snow_cone))
            .appendPath(resources.getResourceTypeName(R.drawable.android_snow_cone))
            .appendPath(resources.getResourceEntryName(R.drawable.android_snow_cone))
            .build()
    }

    internal fun applyBlur(blurLevel: Int) {
        // Add WorkRequest to Cleanup temporary images
        var continuation = workManager
            .beginUniqueWork(
                IMAGE_MANIPULATION_WORK_NAME,
                ExistingWorkPolicy.REPLACE,
                OneTimeWorkRequest.from(CleanupWorker::class.java)
            )

        // Add WorkRequests to blur the image the number of times requested
        for (i in 0 until blurLevel) {
            val blurBuilder = OneTimeWorkRequestBuilder<BlurWorker>()

            // Input the Uri if this is the first blur operation
            // After the first blur operation the input will be the output of previous
            // blur operations.
            if (i == 0) {
                blurBuilder.setInputData(createInputDataForUri())
            }

            continuation = continuation.then(blurBuilder.build())
        }

        // Create charging constraint
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        // Add WorkRequest to save the image to the filesystem
        val save = OneTimeWorkRequestBuilder<SaveImageToFileWorker>()
            .setConstraints(constraints)
            .addTag(TAG_OUTPUT)
            .build()
        continuation = continuation.then(save)

        // Actually start the work
        continuation.enqueue()
    }
    private fun createInputDataForUri(): Data {
        val builder = Data.Builder()
        imageUri?.let {
            builder.putString(KEY_IMAGE_URI, imageUri.toString())
        }
        return builder.build()
    }
}