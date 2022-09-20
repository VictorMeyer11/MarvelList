package com.example.marvellist.data

import com.example.marvellist.common.Constants
import com.example.marvellist.data.remote.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.TS,
        @Query("hash") hash: String = Constants.HASH,
        @Query("limit") limit: Int = Constants.CHAR_LIMIT
    ): CharacterDto
}