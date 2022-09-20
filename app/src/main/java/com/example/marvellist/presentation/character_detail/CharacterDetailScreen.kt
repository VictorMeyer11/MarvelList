package com.example.marvellist.presentation.character_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvellist.presentation.SharedViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterDetailScreen(
    sharedViewModel: SharedViewModel
) {
    val spacerSize = 20.dp

    sharedViewModel.character?.let { character ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(spacerSize))
            Text(
                text = character.name,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(spacerSize))
            GlideImage(
                imageModel = character.imagePath,
                modifier = Modifier.size(250.dp)
            )
            Spacer(modifier = Modifier.height(spacerSize))
            Text(
                text = character.description,
                fontSize = 17.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(spacerSize))
            Text(
                text = "Comics",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(spacerSize))
            LazyColumn(horizontalAlignment = CenterHorizontally) {
                items(character.comics) { comicName ->
                    Spacer(Modifier.height(spacerSize/4))
                    Text(text = comicName, textAlign = TextAlign.Center)
                    Spacer(Modifier.height(spacerSize/4))
                    Divider()
                }
            }
        }
    }
}
