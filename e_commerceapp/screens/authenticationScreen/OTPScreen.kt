package com.example.e_commerceapp.screens.authenticationScreen

import android.os.CountDownTimer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.customize_objects.HeaderBar
import com.example.e_commerceapp.ui.theme.LightBlack
import com.example.e_commerceapp.ui.theme.MainColor


@Composable
fun OTPTexField(
    focusRequester: FocusRequester,
    onChanged: (TextFieldValue) -> Unit
) {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val keyboardController = LocalSoftwareKeyboardController.current


    OutlinedTextField(
        value = text, onValueChange = { newText ->
            text = if (newText.text.length <= 1) newText else text
            onChanged(text)
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MainColor,
            focusedLabelColor = MainColor,
            cursorColor = MainColor,
            errorBorderColor = Color.Red,
            focusedTextColor = MainColor,
            unfocusedTextColor = MainColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword),
        maxLines = 1,
        modifier = Modifier
            .width(50.dp)
            .focusRequester(focusRequester)
            .onFocusChanged {
                if (it.isFocused) {
                    keyboardController?.show()
                }
            },
        textStyle = TextStyle.Default.copy(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    )
}
@Composable
fun OTPScreen(navController: NavController) {
    //otp mutable list
    var otp1 by remember { mutableStateOf(TextFieldValue("")) }
    var otp2 by remember { mutableStateOf(TextFieldValue("")) }
    var otp3 by remember { mutableStateOf(TextFieldValue("")) }
    var otp4 by remember { mutableStateOf(TextFieldValue("")) }
    var otp5 by remember { mutableStateOf(TextFieldValue("")) }
    val focusRequester1 = FocusRequester()
    val focusRequester2 = FocusRequester()
    val focusRequester3 = FocusRequester()
    val focusRequester4 = FocusRequester()
    val focusRequester5 = FocusRequester()

    //count down
    val timer = object : CountDownTimer(12000, 1000) {
        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {

        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HeaderBar(
            label = "OTP Verification",
            onPreviousClick = {}
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "OTP Verification",
            fontSize = 26.sp,
            fontFamily = FontFamily(Font(R.font.semibold_sf)),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = buildAnnotatedString {
                append("We sent your code to +8801737-***\nThis code is expired in ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = MainColor,
                        fontFamily = FontFamily(Font(R.font.regular_sf))
                    )
                ) {
                    append("120s")
                }
            },
            color = LightBlack,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.regular_sf))
        )

        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OTPTexField(focusRequester = focusRequester1) { newText ->
                otp1 = newText
                if (otp1.text.isNotEmpty()) {
                    focusRequester2.requestFocus()
                }
            }
            OTPTexField(focusRequester = focusRequester2) { newText ->
                otp2 = newText
                if (otp2.text.length == 1) {
                    focusRequester3.requestFocus()
                } else {
                    focusRequester1.requestFocus()
                }
            }
            OTPTexField(focusRequester = focusRequester3) { newText ->
                otp3 = newText
                if (otp3.text.length == 1) {
                    focusRequester4.requestFocus()
                } else {
                    focusRequester2.requestFocus()
                }
            }
            OTPTexField(focusRequester = focusRequester4) { newText ->
                otp4 = newText
                if (otp4.text.length == 1) {
                    focusRequester5.requestFocus()
                } else {
                    focusRequester3.requestFocus()
                }
            }
            OTPTexField(focusRequester = focusRequester5) { newText ->
                otp5 = newText
                if (otp5.text.isEmpty()) {
                    focusRequester4.requestFocus()
                }
            }
        }

        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MainColor,
                contentColor = Color.White
            ),
            onClick = {}
        ) {
            Text(
                text = "Verify",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.semibold_sf))
            )
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Text(
            text = "Resend OTP Code",
            style = TextStyle(
                textDecoration = TextDecoration.Underline
            ),
            color = LightBlack,
            fontWeight = FontWeight(500),
            modifier = Modifier.clickable {},
            fontFamily = FontFamily(Font(R.font.semibold_sf))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OTPScreenPreview() {
    OTPScreen(navController = rememberNavController())
}