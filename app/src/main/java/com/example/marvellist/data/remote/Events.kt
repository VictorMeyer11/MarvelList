package com.example.marvellist.data.remote

data class Events(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)