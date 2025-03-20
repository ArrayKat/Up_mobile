package com.example.upmobileproject.presentation.screens.forgotpass

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.unit.Constraints
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

class ForgotPasswordViewModel : ViewModel() {
    // Состояние для email

    private val _email = MutableStateFlow("")
    val emailU: StateFlow<String> get() = _email

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun  sendEmail(controller: NavHostController, context: Context){
        try{
            viewModelScope.launch {
                Constants.Supabase.auth.resetPasswordForEmail(
                    email = emailU.value
                )
            }
            Toast.makeText(context, "Проверьте Ваш Email", Toast.LENGTH_SHORT).show()
            controller.navigate(NavigationRoutes.VERIFICATION + "/${emailU.value}") {
                popUpTo(NavigationRoutes.FORGOTPASS) {
                    inclusive = true
                }
            }

        }
        catch (e:Exception){
            Toast.makeText(context, "Возникла ошибка: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}