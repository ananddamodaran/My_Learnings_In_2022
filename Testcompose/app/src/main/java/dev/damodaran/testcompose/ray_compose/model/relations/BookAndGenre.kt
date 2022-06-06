package dev.damodaran.testcompose.ray_compose.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import dev.damodaran.testcompose.ray_compose.model.Book
import dev.damodaran.testcompose.ray_compose.model.Genre

data class BookAndGenre(
    @Embedded
    val book: Book,
    @Relation(parentColumn = "bookGenreId", entityColumn = "id")
    val genre: Genre
)