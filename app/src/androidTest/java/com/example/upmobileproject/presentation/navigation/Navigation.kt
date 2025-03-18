package com.example.upmobileproject.presentation.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.upmobileproject.presentation.screens.splash.Splash

@Composable
fun Navigation(controller: NavHostController){
    NavHost(
        navController = controller,
        startDestination = NavigationRoutes.SPLASH
    ) {
        composable(NavigationRoutes.SPLASH){
            Splash(controller)
        }
    }
}

