package com.example.e_commerceapp

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerceapp.customize_objects.CustomizeTextField

@Composable
fun ForgetPasswordScreen() {
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
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Please enter your email to recover your password",
                    color = Color.LightGray,
                    fontSize = 20.sp
                )
            }
            CustomizeTextField(
                placeholder = "thesweetcravings@gmail.com",
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
                    .height(50.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = (Color(33, 166, 145)),
                    contentColor = Color.White
                )

            ) {
                Text(
                    text = "Continue",
                    fontSize = 20.sp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    space = 10.dp,
                    alignment = Alignment.CenterHorizontally
                ),
            ) {
                Text(
                    text = "Don't have an account?",
                    color = Color.LightGray,
                    fontSize = 20.sp
                )
                Text(
                    text = "Sign up",
                    color = Color(33, 166, 145),
                    fontSize = 20.sp,
                    modifier = Modifier.clickable {  }
                )
            }


        }

    }
}

//@Preview (showBackground = true)
@Composable
fun ForgetPassWordPreview() {
    ForgetPasswordScreen()
}