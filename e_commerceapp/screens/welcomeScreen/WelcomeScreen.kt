package com.example.e_commerceapp.screens.welcomeScreen

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
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.ui.theme.DotIndicator
import com.example.e_commerceapp.ui.theme.MainColor

@Composable
fun WelcomeScreen(
    navController: NavHostController
) {
    val currentOnboardingPage = remember { mutableIntStateOf(0) }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MainColor)
    ) {
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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "THE SWEET CRAVINGS",
                    fontSize = 50.sp,
                    lineHeight = 55.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.semibold_sf)),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(10.dp))
                when (currentOnboardingPage.intValue) {
                    0 -> {
                        Text(
                            text = buildAnnotatedString {
                                append(text = "Welcome to ")
                                withStyle(
                                    style = SpanStyle(
                                        fontFamily = FontFamily(Font(R.font.semibold_sf)),
                                        color = Color.White,
                                    )
                                ) {
                                    append("The Sweet Cravings. ")
                                }
                                append("Let's Shop!")
                            },
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.regular_sf)),
                            textAlign = TextAlign.Center
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
                                    "crafted with the finest ingredients.",
                            color = Color.White,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
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
                            text = "Order our pastries today and enjoy a taste of heaven",
                            color = Color.White,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
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
            
            DotIndicator(totalDots = 3, selectedIndex = currentOnboardingPage.intValue)
            Button(
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp),
                onClick = {
                          if (currentOnboardingPage.intValue < 2)
                          {
                              currentOnboardingPage.intValue++
                          } else {
                              navController.navigate("sign-in")
                          }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Continue",
                    fontFamily = FontFamily(Font(R.font.semibold_sf)),
                    color = MainColor,
                    fontWeight = FontWeight(500),
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    val navController = rememberNavController()
    WelcomeScreen(navController)
}

