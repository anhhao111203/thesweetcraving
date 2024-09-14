package com.example.e_commerceapp.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class CompleteProfileViewModel: ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()

    fun saveUserProfile(
        userID: String,
        accountName: String,
        phoneNumber: String,
        address: String,
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit
    ) {
        val userProfile = hashMapOf(
            "accountName" to accountName,
            "phoneNumber" to phoneNumber,
            "address" to address
        )
        firestore.collection("users").document(userID)
            .set(userProfile)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onError(exception)
            }
    }
}