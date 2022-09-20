package com.example.marvellist.presentation.character_list

sealed class CharacterListEvent {
    object IncreaseOffset: CharacterListEvent()
    object DecreaseOffset: CharacterListEvent()
}