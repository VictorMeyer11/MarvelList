package com.example.marvellist.presentation.character_list

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvellist.common.Constants
import com.example.marvellist.common.Resource
import com.example.marvellist.domain.use_case.get_characters.GetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharacters
): ViewModel() {
    private val _state = mutableStateOf(CharacterListState())
    val state: State<CharacterListState> = _state

    var currentOffset by mutableStateOf(0)

    init {
        getCharacters()
    }

     fun getCharacters(event: CharacterListEvent? = null) {
         if(event is CharacterListEvent.IncreaseOffset) {
             currentOffset += Constants.CHAR_LIMIT
         }
         else if(event is CharacterListEvent.DecreaseOffset) {
             currentOffset -= Constants.CHAR_LIMIT
         }
         getCharactersUseCase(currentOffset).onEach { result ->
             when(result) {
                 is Resource.Success -> {
                     _state.value = CharacterListState(characters = result.data ?: emptyList())
                 }
                 is Resource.Error -> {
                     _state.value = CharacterListState(error = result.message ?:
                     "An unexpected error occurred")
                 }
                 is Resource.Loading -> {
                     _state.value = CharacterListState(isLoading = true)
                 }
             }
         }.launchIn(viewModelScope)
    }
}