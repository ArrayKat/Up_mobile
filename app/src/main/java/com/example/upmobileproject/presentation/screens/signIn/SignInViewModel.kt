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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {

    // Состояние для email
    private val _email = MutableStateFlow("")
    val emailU: StateFlow<String> get() = _email

    // Состояние для пароля
    private val _password = MutableStateFlow("")
    val passwordU: StateFlow<String> get() = _password

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }

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
    fun goRegister(navHostController: NavHostController){
        navHostController.navigate(NavigationRoutes.REGISTER){
            popUpTo(NavigationRoutes.SIGNIN){
                inclusive = true
            }
        }
    }
    fun goForgotPass(navHostController: NavHostController){
        navHostController.navigate(NavigationRoutes.FORGOTPASS){
            popUpTo(NavigationRoutes.SIGNIN){
                inclusive = true
            }
        }
    }
}