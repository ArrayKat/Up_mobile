package com.example.upmobileproject.presentation.screens.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    // Состояние для имени
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> get() = _name

    // Состояние для email
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> get() = _email

    // Состояние для пароля
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> get() = _password

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

    // Функция для регистрации
    fun register() {
        viewModelScope.launch {

        }
    }
}