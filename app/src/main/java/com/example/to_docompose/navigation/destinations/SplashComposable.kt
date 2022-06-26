package com.example.to_docompose.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.to_docompose.ui.screens.splash.SplashScreen
import com.example.to_docompose.util.Constants

fun NavGraphBuilder.splashComposable(
    navigateToListScreen : () -> Unit
){
    composable(
     route = Constants.SPLASH_SCREEN,
    ){
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}