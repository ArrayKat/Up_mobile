package com.example.upmobileproject.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.upmobileproject.data.models.Category
import com.example.upmobileproject.data.models.Product
import com.example.upmobileproject.domain.Constants
import com.example.upmobileproject.presentation.navigation.NavigationRoutes
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch

class HomeViewModel :ViewModel() {
    val productList = mutableStateOf<List<Product>>(emptyList())
    val categoryList = mutableStateListOf<Category>()
    val search = mutableStateOf("")
    fun GetData(){
        viewModelScope.launch {
            try{
                val result = Constants.Supabase.from("products").select().decodeList<Product>()
                productList.value = result.take(2)
                val result2 = Constants.Supabase.from("categories").select().decodeList<Category>()
                categoryList.clear()
                categoryList.add(Category(id = "0", title = "Все"))
                categoryList.addAll(result2)
            }
            catch (e:Exception){
                Log.d("category", e.message.toString())
            }
        }
    }

    fun GoCatalog(controller: NavHostController, idCategory: String){
        controller.navigate(NavigationRoutes.CATALOG + "/${idCategory}") {
            popUpTo(NavigationRoutes.HOME) {
                inclusive = true
            }
        }
    }
}