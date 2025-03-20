package com.example.upmobileproject.presentation.comopnents.CustomCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.upmobileproject.R
import com.example.upmobileproject.data.models.Product

@Composable
fun ProductCard(
    product: Product,
    onLikeClick: (Product) -> Unit // Обработчик нажатия на "лайк"
) {
    // Состояние для "лайка"
    var isLiked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            // Иконка "лайка" в правом верхнем углу
            Box {
                IconButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.TopStart)
                ) {
                    Icon(
                        painter = painterResource(id = if (isLiked) R.drawable.ic_favorite else R.drawable.ic_favorite_border),
                        contentDescription = "Like",
                        tint = if (isLiked) Color.Red else Color.Gray
                    )
                }
            }

            // Изображение товара (загружается по URL)

            val imageState = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .size(Size.ORIGINAL)
                    .build()
            ).state
            if(imageState is AsyncImagePainter.State.Success){
                Image(
                    painter = imageState.painter,
                    contentDescription = ""
                )
            }
            if(imageState is AsyncImagePainter.State.Error){
                CircularProgressIndicator()
            }


            // Надпись "BEST SELLER" (если товар является бестселлером)
            if (product.is_best_seller) {
                Text(
                    text = "BEST SELLER",
                    fontSize = 12.sp,
                    color = Color(0xFF48B2E7), // Цвет #48B2E7
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp, start = 5.dp )
                )
            }

            // Название товара
            Text(
                text = product.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp, start = 5.dp )
            )

            // Цена товара
            Text(
                text = "₽ ${product.cost}",
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}