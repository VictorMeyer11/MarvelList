package com.example.marvellist.data.remote

data class Stories(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)