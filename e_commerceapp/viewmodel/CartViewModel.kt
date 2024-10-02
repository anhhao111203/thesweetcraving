package com.example.e_commerceapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.e_commerceapp.dataClass.CartItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class CartViewModel: ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun addToCart(
        foodID: String,
        foodName: String,
        price: Double,
        imageUrl: String,
        quantity: Int = 1,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val userID = auth.currentUser?.uid ?: return
        val cartItem = CartItem(
            foodID = foodID,
            foodName = foodName,
            price = price,
            quantity = quantity,
            imageUrl = imageUrl
        )
        firestore.collection("users").document(userID)
            .collection("cart")
            .document(foodID)
            .set(cartItem)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { exception -> onFailure(exception) }
    }
    suspend fun getCartItem(): List<CartItem> {
        val userID = auth.currentUser?.uid ?: return emptyList()
        val snapshot = firestore.collection("users").document(userID)
            .collection("cart")
            .get()
            .await()

        return snapshot.documents.mapNotNull { it.toObject(CartItem::class.java) }
    }

}