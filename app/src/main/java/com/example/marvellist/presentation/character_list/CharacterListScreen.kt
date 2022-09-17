package com.example.marvellist.presentation.character_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterListScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        GlideImage(
            imageModel = "https://rrtutors.com/uploads/langpostimg/download.jpg",
            modifier = Modifier.size(30.dp)
        )
    }
}