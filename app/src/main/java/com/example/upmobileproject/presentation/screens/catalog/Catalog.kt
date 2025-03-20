package com.example.upmobileproject.presentation.screens.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.upmobileproject.presentation.comopnents.CustomButtonBack
import com.example.upmobileproject.presentation.comopnents.CustomCard.CategoryCard
import com.example.upmobileproject.presentation.comopnents.CustomCard.ProductCard

@Composable
fun Catalog (controller: NavHostController, idCategory: String) {
    val viewModel: CatalogViewModel = viewModel()
    LaunchedEffect(Unit) {
        viewModel.GetData(idCategory)
    }

    Column {

        Spacer(modifier = Modifier.height(48.dp))
        Row{
            CustomButtonBack(onConfirm = {viewModel.goBack(controller)})

        }

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
                    isSelected = viewModel.idCategoryCurrent.value == category.id,
                    onClick = {viewModel.GetProductCategory(category.id)}
                )

            }
        }
        Spacer(modifier = Modifier.height(25.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(viewModel.productList) { product ->
                ProductCard(
                    product = product,
                    onLikeClick = {} // Обработчик нажатия на "лайк"
                )
            }
        }
    }
}




