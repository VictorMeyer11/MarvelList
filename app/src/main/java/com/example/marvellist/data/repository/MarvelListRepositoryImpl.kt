package com.example.marvellist.data.repository

import com.example.marvellist.data.MarvelApi
import com.example.marvellist.data.remote.CharacterDto
import com.example.marvellist.domain.repository.MarvelListRepository
import javax.inject.Inject

class MarvelListRepositoryImpl @Inject constructor(
    private val api: MarvelApi
): MarvelListRepository {
    override suspend fun getCharacters(): CharacterDto {
        return api.getCharacters()
    }

    override suspend fun getCharById(charId: String): CharacterDto {
        return api.getCharById(charId)
    }
}