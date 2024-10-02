package com.example.e_commerceapp.navigation

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
import com.example.e_commerceapp.screens.homeScreen.CartUI
import com.example.e_commerceapp.screens.authenticationScreen.CompleteProfileScreen
import com.example.e_commerceapp.screens.authenticationScreen.ForgetPasswordScreen
import com.example.e_commerceapp.screens.authenticationScreen.RecoverPasswordScreen
import com.example.e_commerceapp.screens.homeScreen.FoodListUI
import com.example.e_commerceapp.screens.homeScreen.HomePageUI
import com.example.e_commerceapp.screens.homeScreen.ProductInformationUI
import com.example.e_commerceapp.screens.authenticationScreen.SignInScreen
import com.example.e_commerceapp.screens.authenticationScreen.SignUpScreen
import com.example.e_commerceapp.screens.homeScreen.Profile
import com.example.e_commerceapp.screens.welcomeScreen.WelcomeScreen
import com.example.e_commerceapp.ui.theme.ECommerceAppTheme
import com.example.e_commerceapp.viewmodel.CompleteProfileViewModel
import com.example.e_commerceapp.viewmodel.SignInViewModel
import com.example.e_commerceapp.viewmodel.SignUpViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        startDestination = "onboarding"
    ) {
        composable("profile") { Profile(navController)}
        composable("cart") { CartUI()}
        composable("onboarding") { WelcomeScreen(navController)}
        // Sign in:
        composable("sign-in") { SignInScreen(navController, signInViewModel) }
        composable("home-page") { HomePageUI(navController) }

        // Sign up:
        composable("sign-up") { SignUpScreen(navController, signUpViewModel) }

        // Forget password:
        composable("forget") { ForgetPasswordScreen(navController) }

        // Recover password:
        composable("recover") { RecoverPasswordScreen(navController) }

        composable("payment") { CartUI() }
        composable("food-list/{categoryName}") { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
            FoodListUI(categoryName = categoryName)
        }
        composable("food-detail/{foodID}") { backStackEntry ->
            val foodID = backStackEntry.arguments?.getString("foodID") ?: ""
            ProductInformationUI(foodID = foodID)
        }
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
