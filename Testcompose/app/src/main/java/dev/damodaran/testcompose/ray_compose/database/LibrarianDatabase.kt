package dev.damodaran.testcompose.ray_compose.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.damodaran.testcompose.ray_compose.database.dao.BookDao
import dev.damodaran.testcompose.ray_compose.database.dao.GenreDao
import dev.damodaran.testcompose.ray_compose.database.migrations.migration_1_2
import dev.damodaran.testcompose.ray_compose.database.migrations.migration_2_3
import dev.damodaran.testcompose.ray_compose.database.migrations.migration_3_4
import dev.damodaran.testcompose.ray_compose.model.Book
import dev.damodaran.testcompose.ray_compose.model.Genre

const val DATABASE_VERSION = 4

@Database(
    entities = [Book::class, Genre::class,],
    version = DATABASE_VERSION
)
abstract  class LibrarianDatabase: RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "Librarian"

        fun buildDatabase(context: Context): LibrarianDatabase {
            return Room.databaseBuilder(
                context,
                LibrarianDatabase::class.java,
                DATABASE_NAME
            ).addMigrations(migration_1_2, migration_2_3, migration_3_4)
                .build()
        }
    }
    abstract fun bookDao(): BookDao

    abstract fun genreDao(): GenreDao
}