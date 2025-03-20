package com.example.upmobileproject.presentation.screens.createpass

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.upmobileproject.presentation.comopnents.CustomTextField
import com.example.upmobileproject.presentation.screens.signIn.SignInViewModel

@Composable
fun CreatePassword (controller: NavHostController) {
    val viewModel: CreatePasswordViewModel = viewModel()
    val password1 by viewModel.passwordU1.collectAsState()
    val password2 by viewModel.passwordU2.collectAsState()
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
            text = "Задать Новый Пароль",
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Установите Новый Пароль Для Входа В ВашуУчетную Запись",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(38.dp))
        CustomTextField(
            label = "Пароль",
            value = password1,
            onValueChange = { viewModel.updatePassword1(it) },
            isPassword = true,
            placeholder = "********",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        CustomTextField(
            label = "Подтверждаение пароля",
            value = password2,
            onValueChange = { viewModel.updatePassword2(it) },
            isPassword = true,
            placeholder = "********",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { viewModel.SavePassword(controller, context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Сохранить")
        }

    }

}