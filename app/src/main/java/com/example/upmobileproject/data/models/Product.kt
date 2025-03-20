package com.example.upmobileproject.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Product (
    val id:String ="",
    val title:String ="",
    val category_id: String ="",
    val cost: Int=0,
    val description: String ="",
    val is_best_seller:Boolean=false,
    val image:String=""
)