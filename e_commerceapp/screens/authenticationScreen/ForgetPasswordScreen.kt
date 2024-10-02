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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.customize_objects.CustomizeTextField
import com.example.e_commerceapp.ui.theme.LightBlack
import com.example.e_commerceapp.ui.theme.MainColor

@Composable
fun ForgetPasswordScreen(
    navController: NavHostController
) {
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }

    val emailErrorState = remember {
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
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Forget password",
                    fontFamily = FontFamily(Font(R.font.semibold_sf)),
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Please enter your email to recover your password",
                    color = LightBlack,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    fontSize = 20.sp
                )
            }
            CustomizeTextField(
                placeholder = "Enter your email",
                trailingIcon = R.drawable.mail,
                label = "Email",
                keyboardType = KeyboardType.Email,
                visualTransformation = VisualTransformation.None,
                errorState = emailErrorState,
                onChanged = { newInputEmail -> email = newInputEmail }
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = {
                          navController.navigate("recover")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor,
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
fun ForgetPassWordPreview() {
    val navController = rememberNavController()
    ForgetPasswordScreen(navController)
}