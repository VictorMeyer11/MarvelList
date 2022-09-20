package com.example.marvellist.data.remote

import com.example.marvellist.common.Constants
import com.example.marvellist.domain.model.Character

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
        imagePath = "${thumbnail.path.replace("http", "https")}/${Constants.IMAGE_SIZE}.${thumbnail.extension}",
        name = name,
        description = description
    )
}