package dev.damodaran.testcompose.ray_compose.ui.composeUI

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.damodaran.testcompose.ray_compose.model.Genre

@Composable
fun DropDownMenu(genres:List<Genre>,
                onItemPicked: (Genre) -> Unit
) {


        val text = remember { mutableStateOf("") } // initial value
        val isOpen = remember { mutableStateOf(false) } // initial value
        val openCloseOfDropDownList: (Boolean) -> Unit = {
            isOpen.value = it
        }
        val userSelectedGenre: (Genre) -> Unit = {
            onItemPicked(it)
            text.value = it.name
        }
        Box {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = text.value,
                    onValueChange = { text.value = it },
                    label = { Text(text = "Genre") },
                )
                DropDownList(
                    requestToOpen = isOpen.value,
                    list = genres,
                    openCloseOfDropDownList,
                    userSelectedGenre
                )
            }
            Spacer(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Transparent)
                    .padding(10.dp)
                    .clickable(
                        onClick = { isOpen.value = true }
                    )
            )
        }


}
@Composable
fun DropDownList(
    requestToOpen: Boolean = false,
    list: List<Genre>,
    request: (Boolean) -> Unit,
    selectedGenre: (Genre) -> Unit
) {
    DropdownMenu(
        modifier = Modifier.fillMaxWidth(),

        expanded = requestToOpen,
        onDismissRequest = { request(false) },
    ) {
        list.forEach {
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                  //  _addBookState.value = _addBookState.value?.copy(genreId = it.id)
                    request(false)
                    selectedGenre(it)
                }
            ) {
                Text(it.name, modifier = Modifier.wrapContentWidth())
            }
        }
    }
}