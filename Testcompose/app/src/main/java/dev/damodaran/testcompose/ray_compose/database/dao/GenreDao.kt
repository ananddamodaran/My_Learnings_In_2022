package dev.damodaran.testcompose.ray_compose.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.damodaran.testcompose.ray_compose.model.Genre

@Dao
interface GenreDao {
    @Query("SELECT * FROM genre")
    suspend fun getGenres(): List<Genre>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGenres(genres: List<Genre>)
}