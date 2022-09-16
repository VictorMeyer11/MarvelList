package com.example.marvellist.data

import com.example.marvellist.data.remote.CharacterDto
import retrofit2.http.GET

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getCharacters(): List<CharacterDto>

    @GET("GET /v1/public/characters/{characterId}")
    suspend fun getCharById(charId: String): CharacterDto
}