package com.example.upmobileproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.upmobileproject.presentation.screens.registration.Register
import com.example.upmobileproject.presentation.screens.signIn.SignIn
import com.example.upmobileproject.presentation.screens.splash.Splash

@Composable
fun Navigation(controller: NavHostController){
    NavHost(
        navController = controller,
        startDestination = NavigationRoutes.REGISTER
    ) {
        composable(NavigationRoutes.SPLASH){
            Splash(controller)
        }
        composable(NavigationRoutes.REGISTER){
            Register(controller)
        }
        composable(NavigationRoutes.SIGNIN){
            SignIn(controller)
        }
    }
}

