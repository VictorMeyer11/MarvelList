package com.example.marvellist.presentation.character_list

import com.example.marvellist.domain.model.Character

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = ""
)
