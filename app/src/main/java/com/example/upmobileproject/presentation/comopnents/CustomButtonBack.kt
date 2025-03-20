package com.example.upmobileproject.presentation.comopnents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.upmobileproject.R

@Composable
fun CustomButtonBack (
    onConfirm: () -> Unit
){
     Box(
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 16.dp)
     ) {
         Box(
             modifier = Modifier
                 .size(40.dp)
                 .background(color = Color(0xFFF7F7F9), shape = CircleShape)
                 .align(Alignment.TopStart)
         ) {
             IconButton(
                 onClick = onConfirm,
                 modifier = Modifier
                     .size(40.dp)
                     .align(Alignment.Center)
             ) {
                 Icon(
                     painter = painterResource(id = R.drawable.ic_arrow_back),
                     contentDescription = "Назад",
                     tint = Color.Black
                 )
             }
         }
     }
}