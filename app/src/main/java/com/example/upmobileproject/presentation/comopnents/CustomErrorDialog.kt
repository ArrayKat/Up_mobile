package com.example.upmobileproject.presentation.comopnents

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import io.ktor.websocket.Frame


@Composable
fun CustomErrorDialog(
    message: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Frame.Text("Ошибка") },
        text = { Frame.Text(message) },
        confirmButton = {
            Button(onClick = onDismiss) {
                Frame.Text("OK")
            }
        }
    )
}