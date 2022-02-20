package dev.damodaran.android_playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.damodaran.android_playground.ui.theme.Android_playgroundTheme

class OnBoardActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Android_playgroundTheme {
                // A surface container using the 'background' color from the theme
                var shouldShowOnboarding by remember { mutableStateOf(true) }

                if (shouldShowOnboarding) { // Where does this come from?
                    OnboardingScreen(onContinueClicked = {

                        shouldShowOnboarding = !shouldShowOnboarding

                    })
                } else {
                    MyApp()
                }


            }
        }
    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Composable
fun Gr3eeting(name: String) {
    //Text(text = "Hello, $name!", modifier = Modifier.padding(24.dp))
    var expanded = remember { mutableStateOf(false) }//
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(
            vertical = 4.dp, horizontal = 8.dp
        )
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)

            ) {
                Text(text = "Hello,")
                Text(text = name)
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }

        }

    }


}


@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun DefaultPreview2() {
    Android_playgroundTheme {
        OnboardingScreen(onContinueClicked = {}) // Do nothing on click.

    }
}