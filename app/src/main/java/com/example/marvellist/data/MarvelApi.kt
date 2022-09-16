package com.example.marvellist.data

import retrofit2.http.GET

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getCharacters: List<CharacterDto>
}