package com.example.upmobileproject.presentation.screens.createpass

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.upmobileproject.domain.Constants
import com.example.upmobileproject.presentation.navigation.NavigationRoutes
import io.github.jan.supabase.gotrue.auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CreatePasswordViewModel : ViewModel(){

    // Состояние для пароля
    private val _password1 = MutableStateFlow("")
    val passwordU1: StateFlow<String> get() = _password1

    // Состояние для пароля
    private val _password2 = MutableStateFlow("")
    val passwordU2: StateFlow<String> get() = _password2


    fun updatePassword1(newPassword1: String) {
        _password1.value = newPassword1
    }
    fun updatePassword2(newPassword2: String) {
        _password2.value = newPassword2
    }

    fun isValidPass(pass: String): Boolean {
        val emailPattern = "^.{6,}$".toRegex()
        return emailPattern.matches(pass)
    }

    fun SavePassword(controller: NavHostController, context: Context){
        viewModelScope.launch {
            if(isValidPass(passwordU1.value)){
                if(passwordU1.value == passwordU2.value) {
                    Constants.Supabase.auth.updateUser {
                        password = passwordU1.value
                    }
                    Toast.makeText(context, "Вы успешно поменяли пароль!", Toast.LENGTH_SHORT).show()
                    controller.navigate(NavigationRoutes.SIGNIN) {
                        popUpTo(NavigationRoutes.CREATEPASS) {
                            inclusive = true
                        }
                    }
                }
                else{
                    Toast.makeText(context, "Проверьте что 2 пароля совпадают.", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(context, "Пароль должен состоять из 6 и более символов", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun goBack(controller: NavHostController){
        controller.navigate(NavigationRoutes.SIGNIN) {
            popUpTo(NavigationRoutes.CREATEPASS) {
                inclusive = true
            }
        }

    }

}