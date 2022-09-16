package com.example.marvellist.data.remote

import com.example.marvellist.domain.model.Character

data class CharacterDto(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)