package com.example.e_commerceapp.dataClass

data class CartItem(
    val foodID: String = "",
    val foodName: String = "",
    val quantity: Int = 1,
    val price: Double = 0.0,
    val imageUrl: String = ""
)