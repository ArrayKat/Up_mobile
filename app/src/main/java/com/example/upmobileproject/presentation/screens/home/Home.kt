package com.example.upmobileproject.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.upmobileproject.R
import com.example.upmobileproject.presentation.comopnents.home.CategoryCard
import com.example.upmobileproject.presentation.comopnents.home.ProductCard

@Composable
fun Home (controller: NavHostController) {
    val viewModel: HomeViewModel = viewModel()
    LaunchedEffect(Unit) {
        viewModel.GetProducts()
    }
    Column (

    ) {
        Spacer(modifier = Modifier.height(140.dp))
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
                    onClick = {}
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