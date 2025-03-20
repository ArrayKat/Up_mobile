package com.example.upmobileproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.upmobileproject.presentation.screens.createpass.CreatePassword
import com.example.upmobileproject.presentation.screens.forgotpass.ForgotPassword
import com.example.upmobileproject.presentation.screens.home.Home
import com.example.upmobileproject.presentation.screens.registration.Register
import com.example.upmobileproject.presentation.screens.signIn.SignIn
import com.example.upmobileproject.presentation.screens.splash.Splash
import com.example.upmobileproject.presentation.screens.verification.Verification

@Composable
fun Navigation(controller: NavHostController){
    NavHost(
        navController = controller,
        startDestination = NavigationRoutes.HOME
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
        composable(NavigationRoutes.FORGOTPASS){
            ForgotPassword(controller)
        }
        composable(NavigationRoutes.VERIFICATION + "/{emailU}"){
            arg ->
            val userEmail = arg.arguments?.getString("emailU")
            Verification(controller, userEmail?:"")
        }
        composable(NavigationRoutes.CREATEPASS){
            CreatePassword(controller)
        }
        composable(NavigationRoutes.SIGNIN){
            SignIn(controller)
        }
        composable(NavigationRoutes.HOME){
            Home(controller)
        }
    }
}

