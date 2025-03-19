package com.example.upmobileproject.presentation.screens.signIn

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.upmobileproject.presentation.comopnents.CustomTextField

@Composable
fun SignIn (controller: NavHostController) {
    val vm = viewModel{ SignInViewModel() }
    Column {
        OutlinedTextField(
            vm.emailU.value,
            {vm.emailU.value = it},
            textStyle = TextStyle(fontSize =  30.sp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor= Color(0xff16a085), // цвет при получении фокуса
                unfocusedBorderColor = Color(0xffcccccc)  // цвет при отсутствии фокуса
            )
        )
        OutlinedTextField(
            vm.passwordU.value,
            {vm.passwordU.value = it},
            textStyle = TextStyle(fontSize =  30.sp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor= Color(0xff16a085), // цвет при получении фокуса
                unfocusedBorderColor = Color(0xffcccccc)  // цвет при отсутствии фокуса
            )
        )
        Button(onClick = {vm.SignIn(controller)},
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(0xff004D40),       // цвет текста
                containerColor = Color(0xff9ed6df)
            )     // цвет фона
        ){ Text("Войти", fontSize = 28.sp) }

        if(vm.openDialog.value){
            AlertDialog(
                onDismissRequest = {vm.openDialog.value = false},
                title = { Text(text = "Ошибка") },
                text = { Text(vm.textError.value) },
                confirmButton = {
                    Button({ vm.openDialog.value = false }, border = BorderStroke(1.dp, Color.LightGray)) {
                        Text("Удалить", fontSize = 22.sp)
                    }
                },
                dismissButton = {
                    Button(
                        onClick = { vm.openDialog.value = false }, border = BorderStroke(1.dp, Color.LightGray)
                    ) {
                        Text("Отмена", fontSize = 22.sp)
                    }
                },
                containerColor = Color.DarkGray,
                titleContentColor = Color.LightGray,
                textContentColor = Color.LightGray,
                iconContentColor = Color.LightGray
            )
        }
    }
}