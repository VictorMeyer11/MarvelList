package com.example.marvellist.data.remote

data class Comics(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)