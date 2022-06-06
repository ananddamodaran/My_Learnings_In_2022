package dev.damodaran.testcompose.ray_compose.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.damodaran.testcompose.ray_compose.database.LibrarianDatabase
import dev.damodaran.testcompose.ray_compose.database.dao.BookDao
import dev.damodaran.testcompose.ray_compose.database.dao.GenreDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun librarianDatabase(@ApplicationContext context: Context): LibrarianDatabase {
        return LibrarianDatabase.buildDatabase(context)
    }
    @Provides
    fun bookDao(database: LibrarianDatabase): BookDao = database.bookDao()
    @Provides
    fun genreDao(database: LibrarianDatabase): GenreDao = database.genreDao()
}