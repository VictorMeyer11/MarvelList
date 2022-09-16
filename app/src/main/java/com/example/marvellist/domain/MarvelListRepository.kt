package com.example.marvellist.domain

import com.example.marvellist.data.remote.CharacterDto

interface MarvelListRepository {
    suspend fun getCharacters(): List<CharacterDto>

    suspend fun getCharById(charId: String): CharacterDto
}