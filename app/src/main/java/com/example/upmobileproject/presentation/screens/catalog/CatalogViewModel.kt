package com.example.upmobileproject.presentation.screens.catalog

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

class CatalogViewModel : ViewModel() {

    val productList = mutableStateListOf<Product>()
    val categoryList = mutableStateListOf<Category>()
    val idCategoryCurrent = mutableStateOf("")

    fun goBack(controller: NavHostController){
        controller.navigate(NavigationRoutes.HOME) {
            popUpTo(NavigationRoutes.CATALOG) {
                inclusive = true
            }
        }

    }

    fun GetData(idCategory: String){
        viewModelScope.launch {
            try{
                val result = Constants.Supabase.from("categories").select().decodeList<Category>()
                categoryList.clear()
                categoryList.add(Category(id = "0", title = "Все"))
                categoryList.addAll(result)
                GetProductCategory(idCategory)
            }
            catch (e:Exception){
                Log.d("category", e.message.toString())
            }
        }
    }

    fun GetProductCategory(idCategory: String){
        idCategoryCurrent.value = idCategory
        viewModelScope.launch {
            try{

                productList.clear()
                if(idCategory == "0"){
                    val result = Constants.Supabase.from("products").select().decodeList<Product>()
                    productList.addAll(result)
                }
                else{
                    val result = Constants.Supabase.from("products").select(){
                        filter {
                            eq("category_id", idCategory)
                        }
                    }.decodeList<Product>()
                    productList.addAll(result)
                }

            }
            catch (e:Exception){
                Log.d("category", e.message.toString())
            }
        }
    }
}