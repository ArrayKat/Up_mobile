package com.example.upmobileproject.presentation.screens.verification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
import com.example.upmobileproject.presentation.comopnents.CustomButtonBack
import com.example.upmobileproject.presentation.comopnents.CustomTextField
import com.example.upmobileproject.presentation.screens.forgotpass.ForgotPasswordViewModel

@Composable
fun Verification (controller: NavHostController, emailU:String){
    val viewModel: VerificationViewModel = viewModel()
    val token by viewModel.token.collectAsState()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(horizontal = 20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(65.dp))
        CustomButtonBack(onConfirm = {viewModel.goBack(controller)})
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "OTP Проверка",
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Пожалуйста, Проверьте Свою Электронную Почту, Чтобы Увидеть Код Подтверждения",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(55.dp))

        CustomTextField(
            label = "OTP Код",
            value = token,
            onValueChange = { viewModel.updateToken(it) },
            keyboardType = KeyboardType.Number,
            placeholder = "000000",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { viewModel.checkCode(emailU, controller, context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Проверить")
        }
        Spacer(modifier = Modifier.height(210.dp))

    }
}