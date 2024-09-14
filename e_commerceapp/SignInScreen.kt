package com.example.e_commerceapp

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerceapp.customize_objects.CustomizeTextField
import com.example.e_commerceapp.customize_objects.HeaderBar
import com.example.e_commerceapp.viewmodel.SignInViewModel
import com.facebook.login.LoginManager

@Composable
fun SignInScreen(
    navController: NavHostController,
    viewModel: SignInViewModel = viewModel()
) {
    val signInState by viewModel.signInState.observeAsState()

    // immutable variables to save the error state of user's input
    val emailErrorState = remember {
        mutableStateOf(false)
    }
    val passwordErrorState =  remember {
        mutableStateOf(false)
    }

    // mutable variables to save the user's input
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }

    // UI design
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background((Color.White))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderBar(
                label = "Sign in",
                onPreviousClick = {}
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Welcome back",
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.semibold_sf)),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Sign in with your email and password",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    color = Color(0xFFBEC3C6)
                )
            }
            Column(
                modifier = Modifier.weight(0.2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomizeTextField(
                    placeholder = "thesweetcravings@gmail.com",
                    trailingIcon = R.drawable.mail,
                    label = "Email",
                    keyboardType = KeyboardType.Email,
                    visualTransformation = VisualTransformation.None,
                    errorState = emailErrorState,
                    onChanged = { newEmail -> email = newEmail }
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomizeTextField(
                    placeholder = "********",
                    trailingIcon = R.drawable.lock,
                    label = "Password",
                    keyboardType = KeyboardType.Password,
                    visualTransformation = PasswordVisualTransformation(),
                    errorState = passwordErrorState,
                    onChanged = { newPassword -> password = newPassword }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Checkbox(checked = false, onCheckedChange = null)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Remember me",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.regular_sf))
                    )
                }
                Text(
                    text = "Forget password?",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable {  }
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(33, 166, 145),
                    contentColor = Color.White
                ),
                onClick = {
                    viewModel.signIn(email.text, password.text)
                }
            ) {
                Text(
                    text = "Sign in",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.semibold_sf))
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.weight(0.3f)
            ) {
                Text(
                    text = "Or sign in with:",
                    color = Color(0xFFBEC3C6),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf))
                )
                // For Facebook, Google login:
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 10.dp,
                        alignment = Alignment.CenterHorizontally
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                Color(128, 192, 182),
                                shape = CircleShape
                            )
                            .size(50.dp)
                            .clickable {
                                // Call Facebook login function
                                LoginManager.getInstance().logInWithReadPermissions(
                                    navController.context as Activity,
                                    listOf("email", "public_profile")
                                )
                            },
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "Facebook logo",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .background(
                                Color(128, 192, 182),
                                shape = CircleShape
                            )
                            .size(50.dp)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.google_icon),
                            contentDescription = "Google logo",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Don't have an account?",
                        color = Color(0xFFBEC3C6),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.regular_sf))
                    )
                    Text(
                        text = "Sign up",
                        color = Color(33, 166, 145),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.regular_sf)),
                        modifier = Modifier.padding(start = 6.dp)
                    )
                }
            }
        }
    }
    when (signInState) {
        is SignInViewModel.SignInState.Success -> {
            // Navigate to the home screen
            navController.navigate("home-page") {
                popUpTo("sign-in") { inclusive = true }
            }
        }
        is SignInViewModel.SignInState.Error -> {
            // Show an error message
//            val errorMessage = (signInState as SignInViewModel.SignInState.Error).message
            // Display the error message (e.g., using a Toast or a Snackbar)
            navController.navigate("sign-up")
        }
        null -> Unit // Initial state or no state
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    val navController = rememberNavController()
    SignInScreen(navController)
}