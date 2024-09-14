package com.example.e_commerceapp

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerceapp.customize_objects.CustomizeTextField
import com.example.e_commerceapp.customize_objects.HeaderBar
import com.example.e_commerceapp.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(
    navController: NavHostController,
    signUpViewModel: SignUpViewModel = viewModel()
) {
    // mutable variables to save the user's input
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var confirmPassword by remember {
        mutableStateOf(TextFieldValue(""))
    }

    // immutable variables to save the error state of every input's user
    val emailErrorState = remember {
        mutableStateOf(false)
    }
    val passwordErrorState = remember {
        mutableStateOf(false)
    }
    val confirmPasswordErrorState = remember {
        mutableStateOf(false)
    }

    // UI design
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // header bar
            HeaderBar(
                label = "Sign up",
                onPreviousClick = {}
            )
            // title and guide for user
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign up",
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.semibold_sf)),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Please enter required information to sign up your account",
                    color = Color.LightGray,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    textAlign = TextAlign.Center
                )
            }
            // text field
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
            ) {
                CustomizeTextField(
                    placeholder = "Enter your email",
                    trailingIcon = R.drawable.mail,
                    label = "Email",
                    keyboardType = KeyboardType.Email,
                    visualTransformation = VisualTransformation.None,
                    errorState = emailErrorState,
                    onChanged = {newInputEmail -> email = newInputEmail}
                )
                CustomizeTextField(
                    placeholder = "Enter your password",
                    trailingIcon = R.drawable.lock,
                    label = "Password",
                    keyboardType = KeyboardType.Password,
                    visualTransformation = PasswordVisualTransformation(),
                    errorState = passwordErrorState,
                    onChanged = {newInputPassword -> password = newInputPassword}
                )
                CustomizeTextField(
                    placeholder = "Enter your password again",
                    trailingIcon = R.drawable.lock,
                    label = "Confirm password",
                    keyboardType = KeyboardType.Password,
                    visualTransformation = PasswordVisualTransformation(),
                    errorState = confirmPasswordErrorState,
                    onChanged = {newInputConfirmPassword -> confirmPassword = newInputConfirmPassword}
                )
            }
            // Complete button
            Button(
                onClick = {
                    emailErrorState.value = email.text.isEmpty()
                    passwordErrorState.value = password.text.isEmpty()
                    confirmPasswordErrorState.value = confirmPassword.text != password.text
                    if(!emailErrorState.value && !passwordErrorState.value && !confirmPasswordErrorState.value ) {
                        signUpViewModel.signUpUser(
                            email = email.text,
                            password = password.text,
                            context = navController.context,
                            onSuccess = { userID ->
                                navController.navigate("complete-profile/$userID")
                            },
                            onFailure = {}
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(33, 166, 145),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Complete",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.semibold_sf))
                )
            }
            // spacer
            Spacer(modifier = Modifier.weight(0.1f))
            // for other sign up method
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(0.2f)
            ) {
                Text(
                    text = "Or sign up with:",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 15.dp,
                        alignment = Alignment.CenterHorizontally
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(128, 192, 182),
                                shape = CircleShape
                            )
                            .size(40.dp)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.google_icon),
                            contentDescription = "Google logo icon",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(128, 192, 182),
                                shape = CircleShape
                            )
                            .size(40.dp)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "Facebook logo icon",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    val navController = rememberNavController()
    SignUpScreen(navController)
}