/*
 * Copyright (c) 2021 Razeware LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 * 
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package dev.damodaran.testnavigation.jetreddit


import android.content.Intent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import dev.damodaran.testnavigation.R
import dev.damodaran.testnavigation.jetreddit.appdrawer.AppDrawer
import dev.damodaran.testnavigation.jetreddit.routing.JetRedditRouter
import dev.damodaran.testnavigation.jetreddit.routing.Screen
import dev.damodaran.testnavigation.jetreddit.screens.*
import dev.damodaran.testnavigation.jetreddit.theme.JetRedditTheme
import dev.damodaran.testnavigation.jetreddit.viewmodel.JRetMainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun JetRedditApp(viewModel: JRetMainViewModel) {
  JetRedditTheme {
    AppContent(viewModel)
  }
}

@ExperimentalAnimationApi
@Composable
private fun AppContent(viewModel: JRetMainViewModel) {
  val scaffoldState: ScaffoldState = rememberScaffoldState()
  val coroutineScope: CoroutineScope = rememberCoroutineScope()

  Crossfade(targetState = JetRedditRouter.currentScreen) { screenState: MutableState<Screen> ->

    Scaffold(
      topBar = getTopBar(screenState.value, scaffoldState, coroutineScope),
      drawerContent = {
        AppDrawer(
          closeDrawerAction = { coroutineScope.launch { scaffoldState.drawerState.close() } }
        )
      },
      scaffoldState = scaffoldState,
      bottomBar = {
        BottomNavigationComponent(screenState = screenState)
      },
      content = {
        MainScreenContainer(
          modifier = Modifier.padding(bottom = 56.dp),
          screenState = screenState,
          viewModel = viewModel
        )
      }
    )
  }
}

fun getTopBar(
  screenState: Screen,
  scaffoldState: ScaffoldState,
  coroutineScope: CoroutineScope
): @Composable (() -> Unit) {
  if (screenState == Screen.MyProfile || screenState == Screen.ChooseCommunity) {
    return {}
  } else {
    return { TopAppBar(scaffoldState = scaffoldState, coroutineScope = coroutineScope) }
  }
}

/**
 * Represents top app bar on the screen
 */
@Composable
fun TopAppBar(scaffoldState: ScaffoldState, coroutineScope: CoroutineScope) {

  val context = LocalContext.current
  val colors = MaterialTheme.colors

  TopAppBar(
    title = {
      Text(
        text = stringResource(JetRedditRouter.currentScreen.value.titleResId),
        color = colors.primaryVariant
      )
    },
    backgroundColor = colors.surface,
    navigationIcon = {
      IconButton(onClick = {
        coroutineScope.launch { scaffoldState.drawerState.open() }
      }) {
        Icon(
          Icons.Filled.AccountCircle,
          tint = Color.LightGray,
          contentDescription = stringResource(id = R.string.account)
        )
      }
    },
    actions = {
      if (JetRedditRouter.currentScreen.value == Screen.Home) {
        IconButton(onClick = {
          context.startActivity(Intent(context, ChatActivity::class.java))
        }) {
          Icon(
            Icons.Filled.MailOutline,
            tint = Color.LightGray,
            contentDescription = "Chat Icon"
          )
        }
      }
    }
  )
}

@ExperimentalAnimationApi
@Composable
private fun MainScreenContainer(
  modifier: Modifier = Modifier,
  screenState: MutableState<Screen>,
  viewModel: JRetMainViewModel
) {
  Surface(
    modifier = modifier,
    color = MaterialTheme.colors.background
  ) {
    when (screenState.value) {
      Screen.Home -> HomeScreen(viewModel)
      Screen.Subscriptions -> SubredditsScreen()
      Screen.NewPost -> AddScreen(viewModel)
      Screen.MyProfile -> MyProfileScreen(viewModel)
      Screen.ChooseCommunity -> ChooseCommunityScreen(viewModel)
    }
  }
}

@Composable
private fun BottomNavigationComponent(
  modifier: Modifier = Modifier,
  screenState: MutableState<Screen>
) {
  var selectedItem by remember { mutableStateOf(0) }

  val items = listOf(
    NavigationItem(0, R.drawable.ic_baseline_home_24, R.string.home_icon, Screen.Home),
    NavigationItem(
      1,
      R.drawable.ic_baseline_format_list_bulleted_24,
      R.string.subscriptions_icon,
      Screen.Subscriptions
    ),
    NavigationItem(2, R.drawable.ic_baseline_add_24, R.string.post_icon, Screen.NewPost),
  )
  BottomNavigation(modifier = modifier) {
    items.forEach {
      BottomNavigationItem(
        icon = {
          Icon(
            imageVector = ImageVector.vectorResource(id = it.vectorResourceId),
            contentDescription = stringResource(id = it.contentDescriptionResourceId)
          )
        },
        selected = selectedItem == it.index,
        onClick = {
          selectedItem = it.index
          screenState.value = it.screen
        }
      )
    }
  }
}

private data class NavigationItem(
  val index: Int,
  val vectorResourceId: Int,
  val contentDescriptionResourceId: Int,
  val screen: Screen
)