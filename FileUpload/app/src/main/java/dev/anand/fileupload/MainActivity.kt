package dev.anand.fileupload

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.anand.fileupload.ui.theme.FileUploadTheme
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FileUploadTheme {
                val viewModel = viewModel<FileViewModel>()
                
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center){
                    Button(onClick = {
                        val file = File(cacheDir,"upload.png")
                        file.createNewFile()
                        file.outputStream().use {
                            assets.open("elephant.png").copyTo(it)
                        }
                        viewModel.uploadImage(file = file)

                    }) {
                        Text(text = "Upload image")
                    }
                }
            }
        }
    }
}

