package com.example.marvellist.domain.use_case.get_character

import com.example.marvellist.common.Resource
import com.example.marvellist.domain.model.CharacterDetail
import com.example.marvellist.domain.repository.MarvelListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacter @Inject constructor(
    private val repository: MarvelListRepository
) {
    operator fun invoke(characterId: String): Flow<Resource<CharacterDetail>> = flow {
        try {
            emit(Resource.Loading<CharacterDetail>())
            val characterDetail = repository.getCharById(characterId)
        } catch(e: HttpException) {
            emit(Resource.Error<CharacterDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<CharacterDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}