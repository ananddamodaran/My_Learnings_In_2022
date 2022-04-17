package dev.damodaran.android_playground.tictactoe

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.damodaran.android_playground.tictactoe.ui.theme.Android_playgroundTheme
import kotlinx.coroutines.flow.MutableStateFlow

var player: String = "p1"
var playerStats: Array<String> = arrayOf(
    "", "", "",
    "", "", "",
    "", "", ""
)

class TicTactivity : ComponentActivity() {
    var player by mutableStateOf("p1")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_playgroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TicTacToeGame("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TicTacToeGrid() {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        verticalArrangement = Arrangement.Center
    ) {


        items(9) { i ->
            TicTacToeGridItem(i, whoWins = myLambda)
        }

    }
}

val myLambda: () -> Unit = {
    if (
        playerStats[0] == "X"
        && playerStats[1] == "X"
        && playerStats[2] == "X"
        || playerStats[3] == "X"
        && playerStats[4] == "X"
        && playerStats[5] == "X"
        || playerStats[6] == "X"
        && playerStats[7] == "X"
        && playerStats[8] == "X"
        || playerStats[0] == "X"
        && playerStats[3] == "X"
        && playerStats[6] == "X"
        || playerStats[1] == "X"
        && playerStats[4] == "X"
        && playerStats[7] == "X"
        || playerStats[2] == "X"
        && playerStats[5] == "X"
        && playerStats[8] == "X"
        || playerStats[0] == "X"
        && playerStats[4] == "X"
        && playerStats[8] == "X"
        || playerStats[2] == "X"
        && playerStats[4] == "X"
        && playerStats[6] == "X"
    ) {
        println("Player X wins")
        showToast(context,"Player X wins")
    }else if(
        playerStats[0] == "0"
        && playerStats[1] == "0"
        && playerStats[2] == "0"
        || playerStats[3] == "0"
        && playerStats[4] == "0"
        && playerStats[5] == "0"
        || playerStats[6] == "0"
        && playerStats[7] == "0"
        && playerStats[8] == "0"
        || playerStats[0] == "0"
        && playerStats[3] == "0"
        && playerStats[6] == "0"
        || playerStats[1] == "0"
        && playerStats[4] == "0"
        && playerStats[7] == "0"
        || playerStats[2] == "0"
        && playerStats[5] == "0"
        && playerStats[8] == "0"
        || playerStats[0] == "0"
        && playerStats[4] == "0"
        && playerStats[8] == "0"
        || playerStats[2] == "0"
        && playerStats[4] == "0"
        && playerStats[6] == "0"
    ){
        println("Player 0 wins")
    }
} //lambda function

fun showToast(context: Context, s: String) {
    Toast.makeText(
        context  ,
        s,
        Toast.LENGTH_SHORT
    ).show()
}


@Composable
fun TicTacToeGridItem(index: Int, whoWins: () -> Unit) {
    val btnTxt = MutableStateFlow("")
    val gameStateText by btnTxt.collectAsState()

    Button(
        onClick = {
            if (btnTxt.value == "" && player == "p1") {
                btnTxt.value = "X"
                playerStats[index] = btnTxt.value
                player = "p2"

            } else if (btnTxt.value != "X") {
                btnTxt.value = "0"
                playerStats[index] = btnTxt.value
                player = "p1"
            }
        }, modifier = Modifier
            .width(90.dp)
            .height(90.dp)
            .padding(8.dp)
    ) {
        Text(gameStateText)
    }

    whoWins()

}


@Composable
fun TicTacToeGame(name: String) {
    TicTacToeGrid()
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview3() {
    Android_playgroundTheme {
        TicTacToeGame("Android")
    }
}