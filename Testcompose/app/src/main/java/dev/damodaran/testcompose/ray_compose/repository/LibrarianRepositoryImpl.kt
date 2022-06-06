package dev.damodaran.testcompose.ray_compose.repository

import dev.damodaran.testcompose.ray_compose.database.dao.BookDao
import dev.damodaran.testcompose.ray_compose.database.dao.GenreDao
import dev.damodaran.testcompose.ray_compose.model.Book
import dev.damodaran.testcompose.ray_compose.model.Genre
import dev.damodaran.testcompose.ray_compose.model.relations.BookAndGenre
import javax.inject.Inject

class LibrarianRepositoryImpl @Inject constructor(
    private val bookDao: BookDao,
    private val genreDao: GenreDao
    ) : LibrarianRepository{
    override suspend fun getBooks(): List<BookAndGenre> = bookDao.getBooks()
    override suspend fun getGenres(): List<Genre> = genreDao.getGenres()

    override suspend fun addGenres(genres: List<Genre>) = genreDao.addGenres(genres = genres)
    override suspend fun addBook(book: Book) = bookDao.addBook(book = book)

}