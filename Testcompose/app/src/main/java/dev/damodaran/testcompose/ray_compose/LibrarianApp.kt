package dev.damodaran.testcompose.ray_compose

import android.app.Application
import com.google.gson.Gson
import dagger.hilt.android.HiltAndroidApp
import dev.damodaran.testcompose.ray_compose.model.Genre
import dev.damodaran.testcompose.ray_compose.repository.LibrarianRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class LibrarianApp : Application() {

    @Inject
    lateinit var repository: LibrarianRepository

    companion object {
        private lateinit var instance: LibrarianApp

        val gson by lazy { Gson() }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        GlobalScope.launch {
            if (repository.getGenres().isEmpty()) {
                repository.addGenres(
                    listOf(
                        Genre(name = "Action"),
                        Genre(name = "Adventure"),
                        Genre(name = "Classic"),
                        Genre(name = "Mystery"),
                        Genre(name = "Fantasy"),
                        Genre(name = "Sci-Fi"),
                        Genre(name = "History"),
                        Genre(name = "Horror"),
                        Genre(name = "Romance"),
                        Genre(name = "Short Story"),
                        Genre(name = "Biography"),
                        Genre(name = "Poetry"),
                        Genre(name = "Self-Help"),
                        Genre(name = "Young fiction")
                    )
                )
            }
        }
    }
}