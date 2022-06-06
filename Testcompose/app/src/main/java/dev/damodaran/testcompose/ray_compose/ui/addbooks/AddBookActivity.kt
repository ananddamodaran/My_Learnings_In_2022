package dev.damodaran.testcompose.ray_compose.ui.addbooks

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.damodaran.testcompose.R
import dev.damodaran.testcompose.ray_compose.model.AddBookState
import dev.damodaran.testcompose.ray_compose.model.Book
import dev.damodaran.testcompose.ray_compose.model.Genre
import dev.damodaran.testcompose.ray_compose.repository.LibrarianRepository
import dev.damodaran.testcompose.ray_compose.ui.composeUI.ActionButton
import dev.damodaran.testcompose.ray_compose.ui.composeUI.DropDownMenu
import dev.damodaran.testcompose.ray_compose.ui.composeUI.InputField
import dev.damodaran.testcompose.ray_compose.ui.composeUI.TopBar
import kotlinx.coroutines.launch
import javax.inject.Inject

const val LOG_TAG = "Librariay"

@AndroidEntryPoint
class AddBookActivity : ComponentActivity(), AddBookView {
    private val _addBookState = MutableLiveData(AddBookState())
    private val _genresState = MutableLiveData(emptyList<Genre>())

    @Inject
    lateinit var repository: LibrarianRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AddBookContent() }
    }

    @Preview
    @Composable
    fun AddBookContent() {
        Scaffold(topBar = { AddBookTopBar() }) {
            AddBookFormContent()

        }
        loadGenres()
    }

    private fun loadGenres() {
        lifecycleScope.launch {
            _genresState.value = repository.getGenres()
        }
    }

    @Composable
    fun AddBookTopBar() {
        TopBar(title = stringResource(id = R.string.add_book_title),
            onBackPressed = { onBackPressed() }
        )
    }

    @Composable
    fun AddBookFormContent() {
        val genres = _genresState.value ?: emptyList()
        val isGenresPickerOpen = remember { mutableStateOf(false) }
        val bookNameState = remember { mutableStateOf("") }
        val bookDescriptionState = remember {
            mutableStateOf("")
        }
        val selectedGenreName = genres.firstOrNull {
            it.id ==
                    _addBookState.value?.genreId
        }?.name ?: "None"


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputField(value = bookNameState.value,
                onStateChanged = {
                Log.d(LOG_TAG, "book name valuechanged")
                bookNameState.value = it
                _addBookState.value = _addBookState.value?.copy(name = it)
            },
                label = stringResource(id = R.string.book_title_hint))


            InputField(value = bookDescriptionState.value, onStateChanged = {
                Log.d(LOG_TAG, "book description valuechanged")
                bookDescriptionState.value = it
                _addBookState.value = _addBookState.value?.copy(description = it)

            },
                label = stringResource(id = R.string.book_descrption_hint))

            Spacer(modifier = Modifier.height(10.dp))

            DropDownMenu(genres=genres, onItemPicked =  {
                _addBookState.value = _addBookState.value?.copy(genreId = it.id)

        })
            ActionButton(onClick ={ onAddBookTapped() },text=stringResource(id = R.string.add_book_btn_txt))

        }
    }

    fun onAddBookTapped() {
        val bookState = _addBookState.value ?: return
        if (bookState.name.isNotEmpty() &&
            bookState.description.isNotEmpty() &&
            bookState.genreId.isNotEmpty()
        ) {
            lifecycleScope.launch {
                repository.addBook(
                    Book(
                        name = bookState.name,
                        description = bookState.description,
                        genreId = bookState.genreId
                    )
                )
                onBookAdded()
            }
        }
    }




    override fun onBookAdded() {
        setResult(RESULT_OK)
        finish()
    }
}