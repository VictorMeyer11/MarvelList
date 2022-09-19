package com.example.marvellist.domain.repository

import com.example.marvellist.data.remote.CharacterDto

interface MarvelListRepository {
    suspend fun getCharacters(): CharacterDto
}