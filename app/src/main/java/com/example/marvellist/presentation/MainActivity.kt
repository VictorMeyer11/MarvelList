package com.example.marvellist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvellist.common.Constants
import com.example.marvellist.domain.model.Character
import com.example.marvellist.presentation.character_detail.CharacterDetailScreen
import com.example.marvellist.presentation.character_list.CharacterListScreen
import com.example.marvellist.presentation.ui.theme.MarvelListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.CharacterListScreen.route
                    ) {
                        composable(
                            route = Screen.CharacterListScreen.route
                        ) {
                            CharacterListScreen(navController)
                        }
                        composable(
                            route = Screen.CharacterDetailScreen.route
                        ) {
                            val character =
                                navController.previousBackStackEntry?.savedStateHandle?.get<Character>(Constants.PARAM_CHARACTER)
                            CharacterDetailScreen(character)
                        }
                    }
                }
            }
        }
    }
}