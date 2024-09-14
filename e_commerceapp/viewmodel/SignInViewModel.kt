package com.example.e_commerceapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignInViewModel : ViewModel() {
    private val _signInState = MutableLiveData<SignInState>()
    val signInState: LiveData<SignInState> = _signInState

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val callbackManager: CallbackManager = CallbackManager.Factory.create()

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

    // Sign in with Facebook
    private fun signInWithFacebook(accessToken: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(accessToken.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _signInState.value = SignInState.Success(auth.currentUser)
                } else {
                    _signInState.value = SignInState.Error(task.exception?.message ?: "Facebook login failed")
                }
            }
    }

    fun handleFacebookAccessToken(context: Context, loginResult: LoginResult) {
        signInWithFacebook(loginResult.accessToken)
    }

    sealed class SignInState {
        data class Success(val user: FirebaseUser?) : SignInState()
        data class Error(val message: String) : SignInState()
    }
}