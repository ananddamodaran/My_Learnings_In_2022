package dev.damodaran.testcompose.ray_compose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.damodaran.testcompose.ray_compose.repository.LibrarianRepository
import dev.damodaran.testcompose.ray_compose.repository.LibrarianRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract  class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(repositoryImpl: LibrarianRepositoryImpl): LibrarianRepository
}