package com.example.upmobileproject.presentation.screens.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.upmobileproject.presentation.comopnents.CustomTextField

@Composable
fun Register (controller: NavHostController) {
    val viewModel = RegisterViewModel()
    val name by viewModel.name.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val agreeToTerms by viewModel.agreeToTerms.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Регистрация",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        CustomTextField(
            label = "Ваше имя",
            value = name,
            onValueChange = { viewModel.updateName(it) },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        CustomTextField(
            label = "Email",
            value = email,
            onValueChange = { viewModel.updateEmail(it) },
            keyboardType = KeyboardType.Email,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        CustomTextField(
            label = "Пароль",
            value = password,
            onValueChange = { viewModel.updatePassword(it) },
            isPassword = true,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = agreeToTerms,
                onCheckedChange = { }
            )
            Text(
                text = "Даю согласие на обработку персональных данных",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Button(
            onClick = { viewModel.register() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Зарегистрироваться")
        }

        TextButton(
            onClick = { /* Navigate to login */ }
        ) {
            Text("Есть аккаунт? Войти")
        }
    }
}