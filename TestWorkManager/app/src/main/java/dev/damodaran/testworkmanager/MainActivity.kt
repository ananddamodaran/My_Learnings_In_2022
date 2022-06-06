package dev.damodaran.testworkmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.work.*
import coil.compose.rememberImagePainter
import dev.damodaran.testworkmanager.ui.theme.TestWorkManagerTheme
import dev.damodaran.testworkmanager.worker.ColorFilterWorker
import dev.damodaran.testworkmanager.worker.DownloadWorker
import dev.damodaran.testworkmanager.worker.WorkerKeys

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val downloadRequest = OneTimeWorkRequestBuilder<DownloadWorker>()
            .setConstraints(Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            ).build()
        val colorFilterRequest = OneTimeWorkRequestBuilder<ColorFilterWorker>()
            .build()
        val workManager = WorkManager.getInstance(applicationContext)

        setContent {
            TestWorkManagerTheme {
                val workInfos = workManager.getWorkInfosForUniqueWorkLiveData("download")
                    .observeAsState()
                    .value
                val downloadInfo = remember(key1 = workInfos) {
                    workInfos?.find { it.id == downloadRequest.id }
                }
                val filterInfo = remember(key1 = workInfos) {
                    workInfos?.find { it.id == colorFilterRequest.id }
                }

                val imageUri by derivedStateOf {
                    val downloadUri = downloadInfo?.outputData?.getString(WorkerKeys.IMAGE_URI)?.toUri()
                    val filterUri = filterInfo?.outputData?.getString(WorkerKeys.FILTER_URI)?.toUri()
                    filterUri?:downloadUri


                }
                Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

                    imageUri?.let { uri->
                        Image(painter = rememberImagePainter(data = uri), contentDescription = null,
                            modifier = Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.height(16.dp))


                    }
                    Button(onClick = {
                        workManager.beginUniqueWork("download",ExistingWorkPolicy.KEEP,downloadRequest)
                            .then(colorFilterRequest)
                            .enqueue()

                    },
                    enabled = downloadInfo?.state!= WorkInfo.State.RUNNING
                        ) {
                            Text("Start Download")
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    when(downloadInfo?.state){
                        WorkInfo.State.RUNNING-> Text(text ="Downloading...")
                        WorkInfo.State.SUCCEEDED-> Text(text ="Download succeeded")
                        WorkInfo.State.FAILED-> Text(text ="Download failed")
                        WorkInfo.State.CANCELLED-> Text(text ="Download cancelled")
                        WorkInfo.State.ENQUEUED-> Text(text ="Download enqued")
                        WorkInfo.State.BLOCKED-> Text(text ="Download blocked")
                    }
                    when(filterInfo?.state) {
                        WorkInfo.State.RUNNING -> Text("Applying filter...")
                        WorkInfo.State.SUCCEEDED -> Text("Filter succeeded")
                        WorkInfo.State.FAILED -> Text("Filter failed")
                        WorkInfo.State.CANCELLED -> Text("Filter cancelled")
                        WorkInfo.State.ENQUEUED -> Text("Filter enqueued")
                        WorkInfo.State.BLOCKED -> Text("Filter blocked")
                    }

                }
            }
        }
    }
}