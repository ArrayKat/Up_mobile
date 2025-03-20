package com.example.upmobileproject.presentation.screens.verification

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.upmobileproject.domain.Constants
import com.example.upmobileproject.presentation.navigation.NavigationRoutes
import io.github.jan.supabase.gotrue.OtpType
import io.github.jan.supabase.gotrue.auth
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VerificationViewModel: ViewModel() {
    private val _token = MutableStateFlow("")
    val token: StateFlow<String> get() = _token

    fun updateToken(newToken: String) {
        _token.value = newToken
    }

    fun checkCode(emailU:String, controller: NavHostController, context: Context){
        viewModelScope.launch {
            try{
                Constants.Supabase.auth.verifyEmailOtp(
                    type = OtpType.Email.EMAIL,
                    email = emailU,
                    token = token.value
                )
                Toast.makeText(context, "Все супер!!!", Toast.LENGTH_SHORT).show()
                controller.navigate(NavigationRoutes.CREATEPASS) {
                    popUpTo(NavigationRoutes.VERIFICATION) {
                        inclusive = true
                    }
                }
            }
            catch (e:Exception){
                Toast.makeText(context, "Вы ввели неверный код", Toast.LENGTH_SHORT).show()
            }

        }

    }


}