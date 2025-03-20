package com.example.upmobileproject.presentation.screens.signIn

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.upmobileproject.presentation.comopnents.CustomTextField
import com.example.upmobileproject.presentation.screens.registration.RegisterViewModel

@Composable
fun SignIn (controller: NavHostController) {
    val viewModel: SignInViewModel = viewModel()
    val email by viewModel.emailU.collectAsState()
    val password by viewModel.passwordU.collectAsState()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(horizontal = 20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(120.dp))
        Text(
            text = "Привет!",
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Заполните свои данные",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(55.dp))

        CustomTextField(
            label = "Email",
            value = email,
            onValueChange = { viewModel.updateEmail(it) },
            keyboardType = KeyboardType.Email,
            placeholder = "xyz@gmail.com",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        CustomTextField(
            label = "Пароль",
            value = password,
            onValueChange = { viewModel.updatePassword(it) },
            isPassword = true,
            placeholder = "********",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TextButton(
            onClick = { viewModel.goForgotPass(controller) },

        ) {
            Text("Восстановить")
        }
        Button(
            onClick = { viewModel.SignIn(controller) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Войти")
        }
        Spacer(modifier = Modifier.height(210.dp))
        TextButton(
            onClick = { viewModel.goRegister(controller) }
        ) {
            Text("Вы впервые? Создать")
        }
    }

}