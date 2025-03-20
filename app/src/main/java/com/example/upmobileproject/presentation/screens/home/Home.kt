package com.example.upmobileproject.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.upmobileproject.R
import com.example.upmobileproject.presentation.comopnents.CustomCard.CategoryCard
import com.example.upmobileproject.presentation.comopnents.CustomCard.ProductCard
import androidx.compose.material3.Icon as Icon

@Composable
fun Home (controller: NavHostController) {
    val viewModel: HomeViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.GetData()
    }
    Column {
        Spacer(modifier = Modifier.height(48.dp))
        Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            Icon(
                painter = painterResource(R.drawable.ic_hamburger),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterStart),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text("Главная",
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.align(Alignment.Center))

            Spacer(modifier = Modifier.width(12.dp))

            Box (
                modifier = Modifier.clip(CircleShape).background(Color.White).align(Alignment.CenterEnd),
            ) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_shop),
                    modifier = Modifier.padding(10.dp).size(25.dp),
                    contentDescription = ""
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
            TextField(
                value = viewModel.search.value,
                onValueChange = {
                    viewModel.search.value = it
                },
                modifier = Modifier.weight(1f),

                shape = RoundedCornerShape(15.dp),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedTextColor = Color.Black,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    disabledContainerColor = Color.White
                ),
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                        contentDescription = ""
                    )
                },
                placeholder = {
                    Text("Поиск")
                }
            )
            Spacer(modifier = Modifier.width(14.dp))
            Box (
                modifier = Modifier.clip(CircleShape).background(Color(0xFF48B2E7)),
            ) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_settings),
                    modifier = Modifier.padding(14.dp).size(25.dp),
                    contentDescription = "", tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Категории",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp)
        ){
            items(viewModel.categoryList){ category ->
                CategoryCard(
                    category = category,
                    isSelected = false,
                    onClick = {viewModel.GoCatalog(controller, category.id)}
                )

            }
        }
        Text(
            text = "Популярное",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(34.dp))
        LazyRow (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp)
        ){
            items(viewModel.productList.value) { product ->

                ProductCard(
                    product = product,
                    onLikeClick = {}
                )

            }
        }
        Spacer(modifier = Modifier.height(29.dp))
        Text(
            text = "Акции",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(34.dp))
        Image(
            painter = painterResource(R.drawable.sale),
            contentDescription = "",
            modifier = Modifier
                .width(400.dp)
                .height(120.dp)
        )
    }


}