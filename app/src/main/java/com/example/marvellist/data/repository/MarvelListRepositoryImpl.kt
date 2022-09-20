package com.example.marvellist.data.repository

import com.example.marvellist.data.MarvelApi
import com.example.marvellist.data.remote.CharacterDto
import com.example.marvellist.domain.repository.MarvelListRepository
import javax.inject.Inject

class MarvelListRepositoryImpl @Inject constructor(
    private val api: MarvelApi
): MarvelListRepository {
    override suspend fun getCharacters(offset: Int): CharacterDto {
        return api.getCharacters(offset = offset)
    }
}