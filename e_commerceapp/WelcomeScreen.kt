package com.example.e_commerceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerceapp.ui.theme.DotIndicator

@Composable
fun WelcomeScreen() {
    // Variables:
    // val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.chef))
    // val progress by animateLottieCompositionAsState(composition)
    val currentOnboardingPage = remember { mutableStateOf(0) }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(33, 166, 145))
    ) {
        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "THE SWEET\nCRAVINGS",
                    fontSize = 50.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.muli_bold))
                )
                Spacer(modifier = Modifier.height(5.dp))
                when (currentOnboardingPage.value) {
                    0 -> {
                        Text(
                            text = buildAnnotatedString {
                                append(text = "Welcome to ")
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                    )
                                ) {
                                    append("The Sweet Cravings.")
                                }
                                append(" Let's Shop!")
                            },
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.muli)),
                        )
                        Image(
                            painter = painterResource(id = R.drawable.baker_1),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    1 -> {
                        Text(
                            text = "Indulge in our freshly baked pastries, " +
                                    "crafted with love and the finest ingredients.",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.muli))
                        )
                        Image(
                            painter = painterResource(id = R.drawable.cake),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    else -> {
                        Text(
                            text = "Discover the joy of freshly baked goodness! " +
                                    "Order our pastries today and enjoy a taste of heaven.",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.muli))
                        )
                        Image(
                            painter = painterResource(id = R.drawable.onboarding_bg),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }


            // LottieAnimation(composition = composition, progress = {progress}, modifier = Modifier.size(200.dp))
            DotIndicator(totalDots = 3, selectedIndex = currentOnboardingPage.value)
//            Spacer(modifier = Modifier.height(70.dp))
            Button(
                modifier = Modifier
                    .width(250.dp),
                onClick = {
                          if (currentOnboardingPage.value < 2)
                          {
                              currentOnboardingPage.value++
                          }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Continue",
                    color = Color(0xFF21A89F),
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp
                )
            }
        }
    }
}

//@Preview(showBackground = true, widthDp = 540, heightDp = 1200)
//@Composable
//fun WelcomeScreenPreview() {
//    WelcomeScreen()
//}

