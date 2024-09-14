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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProductInformationUI() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.matcha_tiramisu),
                    contentDescription = "Matcha Tiramisu Image",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
                    .padding(30.dp)
                    .background(color = Color.Transparent, shape = RoundedCornerShape(10.dp))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Matcha Tiramisu",
                            fontFamily = FontFamily(Font(R.font.semibold_sf)),
                            fontSize = 20.sp
                        )
                        Text(
                            text = "55.000 VND",
                            fontFamily = FontFamily(Font(R.font.semibold_sf)),
                            fontSize = 22.sp,
                            color = Color(33, 166, 145)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(33, 166, 145).copy(alpha = 0.2F),
                                shape = CircleShape
                            )
                            .size(60.dp)
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.heart_icon),
                            contentDescription = "Add to favorite icon",
                            tint = Color(33, 166, 145),
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }
                Text(
                    text = "A delightful fusion of Japanese matcha and Italian tiramisu," +
                            " featuring layers of sponge cake soaked in matcha syrup," +
                            " creamy mascarpone, and a dusting of matcha." +
                            " Light, refreshing, and perfect for tea lovers!",
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                    color = Color.Black.copy(alpha = 0.5f),
                    modifier = Modifier.padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(33, 166, 145).copy(alpha = 0.2F),
                                shape = CircleShape
                            )
                            .size(40.dp)
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.minus_icon),
                            contentDescription = "Cart Icon",
                            tint = Color(33, 166, 145),
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                    Text(
                        text = "1",
                        fontFamily = FontFamily(Font(R.font.regular_sf)),
                        fontSize = 20.sp,
                        color = Color(33, 166, 145),
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(33, 166, 145).copy(alpha = 0.2F),
                                shape = CircleShape
                            )
                            .size(40.dp)
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.plus_icon),
                            contentDescription = "Cart Icon",
                            tint = Color(33, 166, 145),
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(33, 166, 145)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .padding(start = 20.dp)
                    ) {
                        Text(
                            text = "Add To Cart",
                            fontFamily = FontFamily(Font(R.font.semibold_sf)),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductInformationUIPreview() {
    ProductInformationUI()
}