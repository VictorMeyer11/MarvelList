package com.example.marvellist.presentation.character_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marvellist.presentation.Screen
import com.example.marvellist.presentation.SharedViewModel
import com.example.marvellist.presentation.character_list.components.CharacterListItem
import com.example.marvellist.presentation.character_list.components.PageButton

@Composable
fun CharacterListScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                if(viewModel.currentOffset > 0 && !state.isLoading) {
                    PageButton(text = "<< Previous page") {
                        viewModel.getCharacters(CharacterListEvent.DecreaseOffset)
                    }
                }
            },
            floatingActionButton = {
                if(state.characters.isNotEmpty() && !state.isLoading) {
                    PageButton(text = "Next page >>") {
                        viewModel.getCharacters(CharacterListEvent.IncreaseOffset)
                    }
                }
            }
        ) { padding ->
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
            ) {
                items(state.characters) { character ->
                    CharacterListItem(
                        character = character,
                        onClick = {
                            sharedViewModel.addCharacter(character)
                            navController.navigate(Screen.CharacterDetailScreen.route)
                        }
                    )
                }
                item {
                    Spacer(Modifier.height(60.dp))
                }
            }
        }
        
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        } else if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}