package com.example.marvellist.data

import com.example.marvellist.BuildConfig
import com.example.marvellist.common.Constants
import com.example.marvellist.data.remote.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Path("apikey") apiKey: String = Constants.API_KEY
    ): CharacterDto
}