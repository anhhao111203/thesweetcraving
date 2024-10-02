package com.example.e_commerceapp.screens.authenticationScreen

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import com.example.e_commerceapp.R
import com.example.e_commerceapp.customize_objects.CustomizeTextField
import com.example.e_commerceapp.customize_objects.HeaderBar
import com.example.e_commerceapp.ui.theme.LightBlack
import com.example.e_commerceapp.ui.theme.MainColor
import com.example.e_commerceapp.viewmodel.SignInViewModel

@Composable
fun SignInScreen(
    navController: NavHostController,
    signInViewModel: SignInViewModel = viewModel()
) {
    val signInState by signInViewModel.signInState.observeAsState()

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
    // For check box state:
    var isChecked by remember {
        mutableStateOf(false)
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
                onPreviousClick = {
                    navController.navigate("onboarding")
                }
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
                    color = LightBlack
                )
            }

            // For text fields:
            Column(
                modifier = Modifier.weight(0.2f),
                verticalArrangement = Arrangement.spacedBy(space = 20.dp, alignment = Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomizeTextField(
                    placeholder = "Enter your email",
                    trailingIcon = R.drawable.mail,
                    label = "Email",
                    keyboardType = KeyboardType.Email,
                    visualTransformation = VisualTransformation.None,
                    errorState = emailErrorState,
                    onChanged = { newEmail -> email = newEmail }
                )
                CustomizeTextField(
                    placeholder = "Enter your password",
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
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {checked ->
                        isChecked = checked
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MainColor
                    )
                )
                Text(
                    text = "Remember me",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf))
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Forget password?",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("forget")
                        }
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor,
                    contentColor = Color.White
                ),
                onClick = {
                    signInViewModel.signIn(email.text, password.text)
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Don't have an account?",
                        color = LightBlack,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.regular_sf))
                    )
                    Text(
                        text = "Sign up",
                        color = MainColor,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.regular_sf)),
                        modifier = Modifier
                            .padding(start = 6.dp)
                            .clickable {
                                navController.navigate("sign-up")
                            }
                    )
                }
            }
        }
    }
    when (signInState) {
        is SignInViewModel.SignInState.Success -> {
            navController.navigate("home-page")
        }
        is SignInViewModel.SignInState.Error -> {}
        null -> Unit // Initial state or no state
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    val navController = rememberNavController()
    SignInScreen(navController)
}