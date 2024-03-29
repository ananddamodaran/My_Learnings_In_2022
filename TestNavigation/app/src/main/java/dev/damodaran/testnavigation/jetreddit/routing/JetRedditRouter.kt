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
package dev.damodaran.testnavigation.jetreddit.routing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import dev.damodaran.testnavigation.R


/**
 * Class defining the screens we have in the app.
 *
 * These objects should match files we have in the screens package
 */
sealed class Screen(val titleResId: Int) {
  object Home : Screen(R.string.home)
  object Subscriptions : Screen(R.string.subreddits)
  object NewPost : Screen(R.string.new_post)
  object MyProfile : Screen(R.string.my_profile)
  object ChooseCommunity : Screen(R.string.choose_community)
}

object JetRedditRouter {
  var currentScreen: MutableState<Screen> = mutableStateOf(
    Screen.Home
  )

  private var previousScreen: MutableState<Screen> = mutableStateOf(
    Screen.Home
  )

  fun navigateTo(destination: Screen) {
    previousScreen.value = currentScreen.value
    currentScreen.value = destination
  }

  fun goBack() {
    currentScreen.value = previousScreen.value
  }
}