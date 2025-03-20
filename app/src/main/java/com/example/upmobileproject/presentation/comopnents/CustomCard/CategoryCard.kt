package com.example.upmobileproject.presentation.comopnents.CustomCard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.upmobileproject.data.models.Category


@Composable
fun CategoryCard(
    category: Category,
    isSelected: Boolean, // Параметр для определения, выбрана ли категория
    onClick: () -> Unit // Обработчик нажатия по категории
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .width(110.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFF48B2E7) else Color.White, // Цвет фона карточки
            contentColor = if (isSelected) Color.White else Color.Black // Цвет текста
        ),
        border = if (isSelected) {
            BorderStroke(2.dp, Color(0xFF48B2E7)) // Рамка, если категория выбрана
        } else {
            null // Нет рамки, если категория не выбрана
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = category.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = if (isSelected) Color.White else Color.Black, // Цвет текста в зависимости от выбора
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}