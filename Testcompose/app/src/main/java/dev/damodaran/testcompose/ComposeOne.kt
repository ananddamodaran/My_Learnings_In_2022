package dev.damodaran.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.damodaran.testcompose.ui.theme.TestcomposeTheme

class ComposeOne : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestcomposeTheme {
                createBizCard()
            }
        }

    }

    @Composable
    fun createBizCard() {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.LightGray,
            contentColor = Color.Black,
            elevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { },

            ) {
            Column(
                modifier = Modifier.padding(15.dp),

                horizontalAlignment = CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.car),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),

                    contentScale = ContentScale.Crop
                )
                Divider()
                CreateProfileInfo()
            }
        }
    }

    @Composable
    fun CreateProfileInfo(){
        Column {
            Text("Anand Damodaran")
            Text("Android/Flutter/IOS Developer")
            Text("@ananddamodaran")



        }
    }


    @Preview(showBackground = true)
    @Composable
    fun previewFunction() {
        TestcomposeTheme {
            createBizCard()
        }
    }
}