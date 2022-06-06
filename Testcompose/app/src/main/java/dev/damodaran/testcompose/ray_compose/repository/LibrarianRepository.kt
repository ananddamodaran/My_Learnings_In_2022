package dev.damodaran.testcompose.ray_compose.repository

import dev.damodaran.testcompose.ray_compose.model.Book
import dev.damodaran.testcompose.ray_compose.model.Genre
import dev.damodaran.testcompose.ray_compose.model.relations.BookAndGenre

interface LibrarianRepository {
    suspend fun getBooks(): List<BookAndGenre>
    suspend fun getGenres():List<Genre>
    suspend fun addGenres(genres:List<Genre>)
    suspend fun addBook(book: Book)


}