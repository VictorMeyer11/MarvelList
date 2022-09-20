package com.example.marvellist.presentation.character_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.marvellist.domain.model.Character
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterListItem(
    character: Character,
    onClick: (Character) -> Unit
) {
    Row(modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(character) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        GlideImage(
            imageModel = character.imagePath,
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = character.name,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}