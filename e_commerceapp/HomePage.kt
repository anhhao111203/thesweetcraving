package com.example.e_commerceapp

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun HomePageUI(navController: NavHostController) {
    var searchQuery by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Column {
                Text(
                    text = "Deliver To:",
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    color = Color(0xFFBEC3C6)
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.address_icon),
                        contentDescription = "Address icon",
                        modifier = Modifier.size(20.dp),
                        tint = Color(33, 166, 145)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "264 Tỉnh Lộ 2, ấp Xóm Mới, xã Trung Lập Hạ, huyện Củ Chi, TP. HCM",
                        fontFamily = FontFamily(Font(R.font.regular_sf)),
                        maxLines = 1
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .background(
                            color = Color(33, 166, 145).copy(alpha = 0.2F),
                            shape = RoundedCornerShape(10.dp)
                        ) // Rounded background
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "Search Icon",
                        tint = Color(33, 166, 145),
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterStart)
                    )
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = {
                            Text(
                                text = "Search product",
                                color = Color(33, 166, 145)
                            )
                        },
                        textStyle = TextStyle(
                            color = Color(0xFF9E7C6F),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(R.font.regular_sf))
                        ),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            unfocusedTextColor = Color.Transparent,
                            focusedTextColor = Color.Transparent
                        ),
                        modifier = Modifier.padding(start = 20.dp)
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
                        painter = painterResource(id = R.drawable.cart_icon),
                        contentDescription = "Cart Icon",
                        tint = Color(33, 166, 145),
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                            .height(90.dp)
                            .background(
                                color = Color(33, 166, 145),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("A Spring Surprise", color = Color.White)
                        Text(
                            "Cashback 25%",
                            color = Color.White,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.deal_icon),
                                contentDescription = "Deal icon",
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        Color(33, 166, 145).copy(alpha = 0.2F),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(10.dp),
                                tint = Color(33, 166, 145)
                            )
                            Text(
                                text = "Flash\nDeal",
                                fontFamily = FontFamily(Font(R.font.regular_sf)),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.gift_icon),
                                contentDescription = "Gift icon",
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        Color(33, 166, 145).copy(alpha = 0.2F),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(10.dp),
                                tint = Color(33, 166, 145)
                            )
                            Text(
                                text = "Daily\nGift",
                                fontFamily = FontFamily(Font(R.font.regular_sf)),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.freeship_icon),
                                contentDescription = "Free ship icon",
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        Color(33, 166, 145).copy(alpha = 0.2F),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(10.dp),
                                tint = Color(33, 166, 145)
                            )
                            Text(
                                text = "Free\nShip",
                                fontFamily = FontFamily(Font(R.font.regular_sf)),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                item {
                    CategoryUI()
                }
                item {
                    FlashSaleUI()
                }
                item {
                    BestSellerUI()
                }
            }
            BottomNavigationBarUI(
                navController = navController
            )
        }
    }
}

@Composable
fun BestSellerUI() {
    Text(
        text = "Best Seller",
        fontFamily = FontFamily(Font(R.font.semibold_sf)),
        fontSize = 18.sp,
        modifier = Modifier.padding(top = 30.dp)
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            BestSellerCardItem(
                imageID = R.drawable.matcha_tiramisu,
                contentDescription = "Matcha Tiramisu Image",
                cardItemName = "Matcha Tiramisu",
                cardItemPrice = 55.000
            )
        }
        item {
            BestSellerCardItem(
                imageID = R.drawable.chocolate_tiramisu,
                contentDescription = "Chocolate Tiramisu Image",
                cardItemName = "Chocolate Tiramisu",
                cardItemPrice = 60.000
            )
        }
        item {
            BestSellerCardItem(
                imageID = R.drawable.triple_berry_tiramisu,
                contentDescription = "Triple Berry Tiramisu Image",
                cardItemName = "Triple Berry Tiramisu",
                cardItemPrice = 50.000
            )
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun FlashSaleUI() {
    var remainingTime by remember { mutableLongStateOf(3600L) } // 1 hour in seconds

    LaunchedEffect(Unit) {
        while (remainingTime > 0) {
            delay(1000L) // 1 second delay
            remainingTime--
        }
    }
    // Convert remaining time into hours, minutes, and seconds
    val hours = remainingTime / 3600
    val minutes = (remainingTime % 3600) / 60
    val seconds = remainingTime % 60
    Row(
        modifier = Modifier.padding(top = 30.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.cake_icon),
            contentDescription = "Cake Icon",
            tint = Color(33, 166, 145),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "FLASH SALE",
            fontFamily = FontFamily(Font(R.font.semibold_sf)),
            fontSize = 20.sp,
            color = Color(33, 166, 145),
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = String.format("%02d:%02d:%02d", hours, minutes, seconds),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color(33, 166, 145) // Adjust color as needed
            )
        )
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            FlashSaleCardItem(
                imageID = R.drawable.matcha_tiramisu,
                contentDescription = "Matcha Tiramisu Image",
                cardItemName = "Matcha Tiramisu",
                originalPrice = 55.000,
                salePrice = 40.000
            )
        }
        item {
            FlashSaleCardItem(
                imageID = R.drawable.triple_berry_tiramisu,
                contentDescription = "Triple Berry Image",
                cardItemName = "Triple Berry Tiramisu",
                originalPrice = 50.000,
                salePrice = 40.000
            )
        }
    }
}

@Composable
fun CategoryCardItem(
    imageID: Int,
    contentDescription: String,
    cardItemCategoryName: String,
    numberOfProducts: Int
) {
    Box(
        modifier = Modifier
            .width(280.dp)
            .height(150.dp)
            .padding(top = 15.dp)
    ) {
        Image(
            painter = painterResource(imageID),
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.5F)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = cardItemCategoryName,
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.semibold_sf))
            )
            Text(
                text = "$numberOfProducts products",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.regular_sf))
            )
        }
    }
}

@Composable
fun BestSellerCardItem(
    imageID: Int,
    contentDescription: String,
    cardItemName: String,
    cardItemPrice: Double
) {
    Column {
        Image(
            painter = painterResource(imageID),
            contentDescription = contentDescription,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(150.dp),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = cardItemName,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.regular_sf)),
            modifier = Modifier.padding(top = 6.dp)
        )
        Text(
            text = "$cardItemPrice VND",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.semibold_sf)),
            color = Color(33, 166, 145)
        )
    }
}
@Composable
fun FlashSaleCardItem(
    imageID: Int,
    contentDescription: String,
    cardItemName: String,
    originalPrice: Double,
    salePrice: Double
) {
    Column {
        Image(
            painter = painterResource(imageID),
            contentDescription = contentDescription,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(150.dp),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = cardItemName,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.regular_sf)),
            modifier = Modifier.padding(top = 6.dp)
        )
        Text(
            text = "$originalPrice VND",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.regular_sf)),
            color = Color(0xFFBEC3C6),
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "$salePrice VND",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.semibold_sf)),
            color = Color(33, 166, 145)
        )
    }
}

@Composable
fun CategoryUI() {
    Text(
        text = "Categories",
        fontFamily = FontFamily(Font(R.font.semibold_sf)),
        fontSize = 18.sp,
        modifier = Modifier.padding(top = 30.dp)
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            CategoryCardItem(
                imageID = R.drawable.category_item_1,
                contentDescription = "Birthday Cake Image",
                cardItemCategoryName = "Birthday Cake",
                numberOfProducts = 12
            )
        }
        item {
            CategoryCardItem(
                imageID = R.drawable.category_item_2,
                contentDescription = "Tiramisu Cake Image",
                cardItemCategoryName = "Tiramisu Cake",
                numberOfProducts = 15
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePageUIPreview() {
    val navController = rememberNavController()
    HomePageUI(navController = navController)
}