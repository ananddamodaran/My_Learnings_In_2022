package dev.anand.timefighter

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.anand.timefighter.ui.theme.TimeFighterTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private val score = mutableStateOf(-1)
    private var gameStarted = false

    private lateinit var countDownTimer: CountDownTimer
    private var initialCountDown: Long = 60000
    private var countDownInterval: Long = 1000
    private var timeLeft = mutableStateOf(60)
    var openDialog = mutableStateOf(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate called. Score is: $score")

        setContent {

            TimeFighterTheme {
                Scaffold(topBar = {
                    SmallTopAppBar(title = { Text(getString(R.string.app_name)) },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            titleContentColor = Color.White,
                        ),
                        actions = {
                            IconButton(onClick = {

                            }) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = "info",
                                    tint = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        })
                }


                ) { paddingValues ->


                    Box(modifier = Modifier.padding(paddingValues)) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = getString(R.string.your_score, score.value))

                            Text(text = getString(R.string.time_left, timeLeft.value))
                        }
                        Column(

                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                onClick = {
                                    incrementScore()
                                },

                                ) {
                                Text(getString(R.string.tap_me))
                            }
                        }

                    }


                }
            }
        }

        if (savedInstanceState != null) {
            score.value = savedInstanceState.getInt(SCORE_KEY)
            timeLeft.value = savedInstanceState.getInt(TIME_LEFT_KEY)
            restoreGame()
        } else {
            resetGame()

        }

    }


    private fun resetGame() {
        score.value = 0

        timeLeft.value = 60

        countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft.value = millisUntilFinished.toInt() / 1000


            }

            override fun onFinish() {
                endGame()
            }

        }
        gameStarted = false
    }

    private fun incrementScore() {
        if (!gameStarted) {
            startGame()
        }
        score.value++

    }

    private fun startGame() {
        countDownTimer.start()
        gameStarted = true
    }

    private fun endGame() {

        Toast.makeText(this, getString(R.string.game_over_message, score.value), Toast.LENGTH_LONG)
            .show()
        resetGame()
    }

    private fun restoreGame() {

        countDownTimer =
            object : CountDownTimer((timeLeft.value * 1000).toLong(), countDownInterval) {
                override fun onTick(millisUntilFinished: Long) {
                    timeLeft.value = millisUntilFinished.toInt() / 1000

                }

                override fun onFinish() {
                    endGame()
                }
            }
        countDownTimer.start()
        gameStarted = true
    }

    companion object {
        private const val SCORE_KEY = "SCORE_KEY"
        private const val TIME_LEFT_KEY = "TIME_LEFT_KEY"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(SCORE_KEY, score.value)
        outState.putInt(TIME_LEFT_KEY, timeLeft.value)
        countDownTimer.cancel()
        Log.d(TAG, "onSaveInstanceState: Saving score : $score & Time left : $timeLeft")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy called")
    }


}

@Composable
fun ShowDialog() {
    var openDialog by remember {
        mutableStateOf(true)

    }
    val context = LocalContext.current

    if (openDialog) {
        AlertDialog(onDismissRequest = { openDialog = false }, title = {
            Text(text = context.getString(R.string.about_title, BuildConfig.VERSION_NAME))

        }, text = {
            Text(text = context.getString(R.string.about_message))
        }, confirmButton = {})

    }
}





