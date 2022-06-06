package dev.damodaran.testcompose.ray_compose.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.damodaran.testcompose.ray_compose.model.Book
import dev.damodaran.testcompose.ray_compose.model.relations.BookAndGenre

@Dao
interface BookDao {
    @Query("SELECT * FROM books")
    suspend fun getBooks(): List<BookAndGenre>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBook(book: Book)
}