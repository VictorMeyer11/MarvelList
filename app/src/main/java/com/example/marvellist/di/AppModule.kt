package com.example.marvellist.di

import com.example.marvellist.common.Constants
import com.example.marvellist.data.MarvelApi
import com.example.marvellist.data.repository.MarvelListRepositoryImpl
import com.example.marvellist.domain.repository.MarvelListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): MarvelApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarvelApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: MarvelApi): MarvelListRepository {
        return MarvelListRepositoryImpl(api)
    }
}