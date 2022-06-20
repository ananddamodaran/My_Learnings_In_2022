package dev.anand.dagger_hilt_pg.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.anand.dagger_hilt_pg.data.remote.MyApi
import dev.anand.dagger_hilt_pg.data.repository.MyRepositoryImpl
import dev.anand.dagger_hilt_pg.domain.repository.MyRepository
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMyRepository(
        myRepositoryImpl: MyRepositoryImpl
    ): MyRepository
}