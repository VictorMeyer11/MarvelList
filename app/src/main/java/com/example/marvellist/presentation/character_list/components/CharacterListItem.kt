package com.example.marvellist.presentation.character_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.marvellist.domain.model.Character

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

    }
}