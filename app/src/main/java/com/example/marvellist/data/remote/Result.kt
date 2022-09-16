package com.example.marvellist.data.remote

import com.example.marvellist.domain.model.Character
import com.example.marvellist.domain.model.CharacterDetail

data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: String,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)

fun Result.toCharacter(): Character {
    return Character(
        imagePath = thumbnail.path,
        name = name
    )
}

fun Result.toCharacterDetail(): CharacterDetail {
    return CharacterDetail(
        imagePath = thumbnail.path,
        name = name,
        description = description
    )
}