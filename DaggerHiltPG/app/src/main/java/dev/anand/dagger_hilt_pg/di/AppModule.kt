package dev.anand.dagger_hilt_pg.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.anand.dagger_hilt_pg.data.remote.MyApi
import dev.anand.dagger_hilt_pg.data.repository.MyRepositoryImpl
import dev.anand.dagger_hilt_pg.domain.repository.MyRepository
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): MyApi  = Retrofit.Builder().baseUrl("https://test.com")
        .build().create(MyApi::class.java)



    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "Hello 2"
}