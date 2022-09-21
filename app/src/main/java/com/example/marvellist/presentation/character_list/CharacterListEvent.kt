package com.example.marvellist.presentation.character_list

interface CharacterListEvent {
    object IncreaseOffset: CharacterListEvent
    object DecreaseOffset: CharacterListEvent
}