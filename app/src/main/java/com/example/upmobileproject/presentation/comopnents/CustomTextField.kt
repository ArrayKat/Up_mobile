package com.example.upmobileproject.presentation.comopnents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    label: String, // Название поля (например, "Email")
    value: String, // Текущее значение поля
    onValueChange: (String) -> Unit, // Обработчик изменения значения
    placeholder: String, // Водяной знак (плейсхолдер)
    keyboardType: KeyboardType = KeyboardType.Text, // Тип клавиатуры
    isPassword: Boolean = false, // Поле для пароля (скрытие текста)
    modifier: Modifier = Modifier // Модификатор для кастомизации
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Текст с названием поля
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Поле ввода
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFF7F7F9), shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 20.dp)
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 14.sp,
                    color = Color.Black
                ),
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        // Плейсхолдер (водяной знак)
                        Text(
                            text = placeholder,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                    innerTextField() // Отображение текста
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


