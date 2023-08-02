package com.jetpack.to_docompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.compose.navArgument
import com.jetpack.to_docompose.ui.screens.splash.SplashScreen
import com.jetpack.to_docompose.util.Constants

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen : () -> Unit
){
    composable(
     route = Constants.SPLASH_SCREEN,
        exitTransition = {_,target ->
           slideOutVertically(
               targetOffsetY = { -it },
               animationSpec = tween(2000),
           )
        }
    ){
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}