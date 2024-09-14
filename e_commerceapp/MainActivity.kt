package com.example.e_commerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.e_commerceapp.ui.theme.ECommerceAppTheme
import com.example.e_commerceapp.viewmodel.CompleteProfileViewModel
import com.example.e_commerceapp.viewmodel.SignInViewModel
import com.example.e_commerceapp.viewmodel.SignUpViewModel
import com.facebook.appevents.AppEventsLogger

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        AppEventsLogger.activateApp(application)
        enableEdgeToEdge()
        setContent {
            ECommerceAppTheme {
                val navController = rememberNavController()
                val signInViewModel: SignInViewModel = viewModel()
                val signUpViewModel: SignUpViewModel = viewModel()
                val completeProfileViewModel: CompleteProfileViewModel = viewModel()
                Navigation(navController, signInViewModel, signUpViewModel, completeProfileViewModel)
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController,
               signInViewModel: SignInViewModel,
               signUpViewModel: SignUpViewModel,
               completeProfileViewModel: CompleteProfileViewModel
) {
    NavHost(
        navController = navController,
        startDestination = "sign-in"
    ) {
        composable("sign-in") { SignInScreen(navController, signInViewModel) }
        composable("home-page") { HomePageUI(navController) }
        composable("sign-up") { SignUpScreen(navController, signUpViewModel) }
        composable(
            route = "complete-profile/{userID}",
            arguments = listOf(navArgument("userID") { type = NavType.StringType })
        ) { backStackEntry ->
            val userID = backStackEntry.arguments?.getString("userID") ?: ""
            CompleteProfileScreen(
                navController = navController,
                userID = userID,
                completeProfileViewModel = completeProfileViewModel
            ) }
    }
}
