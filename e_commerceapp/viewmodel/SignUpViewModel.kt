package com.example.e_commerceapp.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignUpViewModel: ViewModel() {
    fun signUpUser(
        email: String,
        password: String,
        context: Context,
        onSuccess: (userID: String) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val auth: FirebaseAuth = Firebase.auth
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                Log.d("Sign up", "Sign up task triggered")
                if (task.isSuccessful) {
                    Log.d("Sign up", "User creation successful")
                    val userID = auth.currentUser?.uid ?: ""
                    Log.d("Sign up", "User ID: $userID")
                    onSuccess(userID)
                } else {
                    Log.d("Sign up", "User creation failed")
                    task.exception?.let {
                        Log.e("Sign up", "Error: ${it.message}")
                        onFailure(it)
                    }
                }
            }
    }
}