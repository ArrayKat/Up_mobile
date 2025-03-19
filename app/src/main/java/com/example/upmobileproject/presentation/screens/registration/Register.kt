package com.example.upmobileproject.presentation.screens.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.upmobileproject.presentation.comopnents.CustomTextField

@Composable
fun Register (controller: NavHostController) {
    val viewModel: RegisterViewModel = viewModel()
    val name by viewModel.name.collectAsState()
    val email by viewModel.emailU.collectAsState()
    val password by viewModel.passwordU.collectAsState()
    val agreeToTerms by viewModel.agreeToTerms.collectAsState()
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
            text = "Регистрация",
            fontSize = 32.sp
        )

        Text(
            text = "Заполните свои данные",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        CustomTextField(
            label = "Ваше имя",
            value = name,
            onValueChange = { viewModel.updateName(it) },
            placeholder = "xxxxxxxx",
            modifier = Modifier.padding(bottom = 8.dp, top = 54.dp)
        )

        CustomTextField(
            label = "Email",
            value = email,
            onValueChange = { viewModel.updateEmail(it) },
            keyboardType = KeyboardType.Email,
            placeholder = "xyz@gmail.com",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        CustomTextField(
            label = "Пароль",
            value = password,
            onValueChange = { viewModel.updatePassword(it) },
            isPassword = true,
            placeholder = "********",
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
                onCheckedChange = { viewModel.updateAgreeToTerms(it)}
            )
            Text(
                text = "Даю согласие на обработку персональных данных",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Button(
            onClick = { viewModel.register(controller, context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Зарегистрироваться")
        }
        Spacer(modifier = Modifier.height(110.dp))
        TextButton(
            onClick = { viewModel.goSignIn(controller)}
        ) {
            Text("Есть аккаунт? Войти")
        }
    }
}