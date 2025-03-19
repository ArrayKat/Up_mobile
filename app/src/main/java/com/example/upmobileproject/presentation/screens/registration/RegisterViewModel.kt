package com.example.upmobileproject.presentation.screens.registration

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.upmobileproject.data.models.profiles
import com.example.upmobileproject.domain.Constants
import com.example.upmobileproject.presentation.navigation.NavigationRoutes
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.sql.Timestamp

class RegisterViewModel : ViewModel() {
    // Состояние для имени
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> get() = _name

    // Состояние для email
    private val _email = MutableStateFlow("")
    val emailU: StateFlow<String> get() = _email

    // Состояние для пароля
    private val _password = MutableStateFlow("")
    val passwordU: StateFlow<String> get() = _password

    // Состояние для согласия на обработку данных
    private val _agreeToTerms = MutableStateFlow(false)
    val agreeToTerms: StateFlow<Boolean> get() = _agreeToTerms

    // Функции для обновления состояния
    fun updateName(newName: String) {
        _name.value = newName
    }

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }

    fun updateAgreeToTerms(agree: Boolean) {
        _agreeToTerms.value = agree
    }

    fun isValidEmail(email: String): Boolean {
        val emailPattern = "^[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,}$".toRegex()
        return emailPattern.matches(email)
    }
    fun isValidPass(pass: String): Boolean {
        val emailPattern = "^.{6,}$".toRegex()
        return emailPattern.matches(pass)
    }
    val showErrorDialog = MutableStateFlow(false)
    val errorMessage = MutableStateFlow("")

    fun goSignIn(controller: NavHostController){
        viewModelScope.launch {
            controller.navigate(NavigationRoutes.SIGNIN) {
                popUpTo(NavigationRoutes.REGISTER) {
                    inclusive = true
                }
            }
        }
    }
    // Функция для регистрации
    fun register(navHostController: NavHostController, context: Context) {
        if(name.value!= "" && emailU.value!= "" && passwordU.value!=""){
            if(isValidEmail(emailU.value)){
                if(isValidPass(passwordU.value)) {
                    if (agreeToTerms.value == true) {
                        try {
                            Log.d("register","Success1")
                            viewModelScope.launch {
                                Constants.Supabase.auth.signUpWith(Email) {
                                    email = emailU.value
                                    password = passwordU.value
                                }
                            }
                            val user = Constants.Supabase.auth.currentUserOrNull()

                            Log.d("register","currentUser")
                            if (user != null) {
                                Log.d(
                                    "sign up",
                                    "Был зарегистрирован следующий пользователь: ${user.id}"
                                )
                                Log.d(
                                    "sign up",
                                    "Пользователь: ${Constants.Supabase.auth.currentUserOrNull()!!.id}"
                                )

                                val newUser = profiles(
                                    user_id = user.id,
                                    created_at = Timestamp(System.currentTimeMillis()).toString(),
                                    firstname = name.value
                                )

                                viewModelScope.launch {
                                    var result = Constants.Supabase.from("profiles").insert(newUser)
                                }
                                Log.d("register","Success")
                                navHostController.navigate(NavigationRoutes.SIGNIN) {
                                    popUpTo(NavigationRoutes.REGISTER) {
                                        inclusive = true
                                    }
                                }
                            }
                        } catch (e: Exception) {
                            Toast.makeText(context, "Что то пошло не так. ${e.message.toString()}", Toast.LENGTH_SHORT).show()
                        }

                    } else {
                        Toast.makeText(context, "Вы не согласились с обработкой данных.", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(context, "Некорректный пароль. Пожалуйста, придумайте пароль, содержащий более 6 символов.", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(context, "Некорректный email. Пожалуйста, введите email в формате name@domenname.com", Toast.LENGTH_SHORT).show()

            }
        }
        else{
            Toast.makeText(context, "Пустые поля. Пожалуйста, заполните все поля.", Toast.LENGTH_SHORT).show()
        }

    }
}