package com.example.upmobileproject.presentation.screens.signIn

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.upmobileproject.domain.Constants
import com.example.upmobileproject.presentation.navigation.NavigationRoutes
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {
    var emailU = mutableStateOf("")
    var passwordU = mutableStateOf("")

    val openDialog = mutableStateOf(false)
    val textError = mutableStateOf("")
    fun SignIn(navHostController: NavHostController){
        viewModelScope.launch {
            try{
                val result = Constants.Supabase.auth.signInWith(Email){
                    this.email = emailU.value
                    this.password = passwordU.value
                }
                navHostController.navigate(NavigationRoutes.HOME){
                    popUpTo(NavigationRoutes.SIGNIN){
                        inclusive = true
                    }
                }
            }
            catch (e:Exception){
                Log.d("auth", e.message.toString())
                openDialog.value = true
                textError.value = e.message.toString()
            }
        }
    }
}