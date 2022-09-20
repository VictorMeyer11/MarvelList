package com.example.marvellist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvellist.presentation.character_detail.CharacterDetailScreen
import com.example.marvellist.presentation.character_list.CharacterListScreen
import com.example.marvellist.presentation.ui.theme.MarvelListTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelListTheme {
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !isSystemInDarkTheme()

                systemUiController.setSystemBarsColor(
                    color = MaterialTheme.colors.primaryVariant,
                    darkIcons = useDarkIcons
                )

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val sharedViewModel: SharedViewModel = viewModel()
                    
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CharacterListScreen.route
                    ) {
                        composable(
                            route = Screen.CharacterListScreen.route
                        ) {
                            CharacterListScreen(navController, sharedViewModel)
                        }
                        composable(
                            route = Screen.CharacterDetailScreen.route
                        ) {
                            CharacterDetailScreen(sharedViewModel)
                        }
                    }
                }
            }
        }
    }
}