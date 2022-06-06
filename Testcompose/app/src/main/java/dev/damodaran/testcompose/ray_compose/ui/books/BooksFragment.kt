package dev.damodaran.testcompose.ray_compose.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import dev.damodaran.testcompose.R

class BooksFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                BooksContent()
            }
        }
    }

    @Preview
    @Composable
    fun BooksContent(){
        Scaffold(topBar = {BooksTopBar()}, floatingActionButton = {AddNewBook()}) {
            
        }
    }
    @Composable
    fun BooksTopBar(){
        TopAppBar(title = { Text(stringResource(id = R.string.my_books_titlle))},
            backgroundColor = colorResource(id = R.color.colorPrimary),
            contentColor = Color.White
        ) 
            

    }
    @Composable
    fun AddNewBook() {
        FloatingActionButton(
            onClick = { }, content = {
                Icon(Icons.Filled.Add, "Add book")

            } )
    }

}