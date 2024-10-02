package com.example.e_commerceapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignInViewModel : ViewModel() {
    private val _signInState = MutableLiveData<SignInState>()
    val signInState: LiveData<SignInState> = _signInState

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Sign in with Email and Password
    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _signInState.value = SignInState.Success(auth.currentUser)
                } else {
                    _signInState.value = SignInState.Error(task.exception?.message ?: "Unknown error")
                }
            }
    }


    sealed class SignInState {
        data class Success(val user: FirebaseUser?) : SignInState()
        data class Error(val message: String) : SignInState()
    }
}