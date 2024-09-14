package com.example.e_commerceapp.viewmodel

import android.content.Context
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
        // A callback function that is invoked when the sign-up process succeeds. It receives the userID of the newly created user.
        onSuccess: (userID: String) -> Unit,
        // A callback function that is invoked when the sign-up process fails. It receives the exception that caused the failure.
        onFailure: (Exception) -> Unit
    ) {
        // This is an instance of FirebaseAuth, the primary entry point for Firebase Authentication,
        // which provides the methods for signing up, signing in, and managing users.
        // Firebase.auth is a shorthand for FirebaseAuth.getInstance().
        val auth: FirebaseAuth = Firebase.auth
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign up success
                    val userID = auth.currentUser?.uid ?: ""
                    Toast.makeText(context, "Sign up successfully", Toast.LENGTH_SHORT).show()
                    onSuccess(userID)
                } else {
                    // Sign up failed
                    task.exception?.let {
                        Toast.makeText(context, "Sign Up Failed: ${it.message}", Toast.LENGTH_LONG)
                            .show()
                        onFailure(it)
                    }
                }
            }
    }
}