package com.example.marvellist.presentation.character_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marvellist.domain.model.Character
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterDetailScreen(character: Character?) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        GlideImage(
            imageModel = character?.imagePath,
            modifier = Modifier.size(30.dp)
        )
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text(text = "${character?.name}")
            Text(text = "${character?.description}")
        }
    }
}
