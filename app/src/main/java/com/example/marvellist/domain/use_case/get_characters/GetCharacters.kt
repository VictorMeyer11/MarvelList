package com.example.marvellist.domain.use_case.get_characters

import com.example.marvellist.common.Resource
import com.example.marvellist.data.remote.toCharacter
import com.example.marvellist.domain.model.Character
import com.example.marvellist.domain.repository.MarvelListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacters @Inject constructor(
    private val repository: MarvelListRepository
) {
    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading<List<Character>>())
            val characters = repository.getCharacters().data.results.map { it.toCharacter() }
            emit(Resource.Success<List<Character>>(characters))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Character>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Character>>("Couldn't reach server. Check your internet connection"))
        }
    }
}