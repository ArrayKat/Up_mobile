package com.example.upmobileproject.presentation.screens.forgotpass

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.upmobileproject.presentation.navigation.NavigationRoutes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ForgotPasswordViewModel : ViewModel() {
    // Состояние для email
    private val _email = MutableStateFlow("")
    val emailU: StateFlow<String> get() = _email

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }


    fun  sendEmail(controller: NavHostController){
        controller.navigate(NavigationRoutes.REGISTER){
            popUpTo(NavigationRoutes.SIGNIN){
                inclusive = true
            }
        }
    }

}