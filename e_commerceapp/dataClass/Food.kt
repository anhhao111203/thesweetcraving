package com.example.e_commerceapp.dataClass

data class Food(
    var foodID: String = "",
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val imageUrl: String = "",
    val category: String = "",
    val salePrice: Double = 0.0
)