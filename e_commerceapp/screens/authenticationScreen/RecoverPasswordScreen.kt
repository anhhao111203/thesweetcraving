package com.example.e_commerceapp.screens.authenticationScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.customize_objects.CustomizeTextField
import com.example.e_commerceapp.ui.theme.LightBlack

@Composable
fun RecoverPasswordScreen(
    navController: NavHostController
) {
    var newPassword by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var confirmPassword by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val passwordErrorState = remember {
        mutableStateOf(false)
    }
    val confirmPasswordErrorState = remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Recover your password",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.semibold_sf))
                )
                Text(
                    text = "Please enter your new password",
                    color = LightBlack,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf))
                )
            }
            Column {
                CustomizeTextField(
                    placeholder = "Enter your password",
                    trailingIcon = R.drawable.lock,
                    label = "New password",
                    keyboardType = KeyboardType.Password,
                    visualTransformation = PasswordVisualTransformation(),
                    errorState = passwordErrorState,
                    onChanged = { newInputPassword -> newPassword = newInputPassword }
                )
                Spacer(modifier = Modifier.height(15.dp))
                CustomizeTextField(
                    placeholder = "Enter your password again",
                    trailingIcon = R.drawable.lock,
                    label = "Confirm password",
                    keyboardType = KeyboardType.Password,
                    visualTransformation = PasswordVisualTransformation(),
                    errorState = confirmPasswordErrorState,
                    onChanged = { newInputConfirmPassword -> confirmPassword = newInputConfirmPassword }
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = {
                          navController.navigate("sign-in")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = (Color(33, 166, 145)),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Continue",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.semibold_sf))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecoverPasswordScreenPreview() {
    val navController = rememberNavController()
    RecoverPasswordScreen(navController)
}