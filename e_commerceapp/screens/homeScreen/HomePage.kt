package com.example.e_commerceapp.screens.homeScreen

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.e_commerceapp.R
import com.example.e_commerceapp.customize_objects.BottomNavigationBarUI
import com.example.e_commerceapp.ui.theme.BackgroundIconColor
import com.example.e_commerceapp.ui.theme.MainColor
import com.example.e_commerceapp.viewmodel.CategoryViewModel
import com.example.e_commerceapp.viewmodel.FlashSaleViewModel
import com.example.e_commerceapp.viewmodel.FoodViewModel
import kotlinx.coroutines.delay
import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomePageUI(
    navController: NavHostController,
) {
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
                    color = Color.Black.copy(alpha = 0.5f)
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.address_icon),
                        contentDescription = "Address icon",
                        modifier = Modifier.size(20.dp),
                        tint = MainColor
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
                            color = BackgroundIconColor,
                            shape = RoundedCornerShape(10.dp)
                        ) // Rounded background
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "Search Icon",
                        tint = MainColor,
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
                                color = MainColor
                            )
                        },
                        textStyle = TextStyle(
                            color = MainColor,
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

                // Cart:
                Box(
                    modifier = Modifier
                        .background(
                            color = BackgroundIconColor,
                            shape = CircleShape
                        )
                        .size(60.dp)
                        .clickable {
                            navController.navigate("cart")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.cart_icon),
                        contentDescription = "Cart Icon",
                        tint = MainColor,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 15.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                            .height(90.dp)
                            .background(
                                color = MainColor,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(15.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("Deal for new customers", color = Color.White)
                        Text(
                            "Buy 1 Get 2",
                            color = Color.White,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
//                item {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 10.dp),
//                        horizontalArrangement = Arrangement.SpaceEvenly
//                    ) {
//                        Column(
//                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            Icon(
//                                painter = painterResource(R.drawable.deal_icon),
//                                contentDescription = "Deal icon",
//                                modifier = Modifier
//                                    .size(50.dp)
//                                    .background(
//                                        BackgroundIconColor,
//                                        shape = RoundedCornerShape(10.dp)
//                                    )
//                                    .padding(10.dp),
//                                tint = MainColor
//                            )
//                            Text(
//                                text = "Flash\nDeal",
//                                fontFamily = FontFamily(Font(R.font.regular_sf)),
//                                fontSize = 16.sp,
//                                textAlign = TextAlign.Center
//                            )
//                        }
//                        Column(
//                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            Icon(
//                                painter = painterResource(R.drawable.gift_icon),
//                                contentDescription = "Gift icon",
//                                modifier = Modifier
//                                    .size(50.dp)
//                                    .background(
//                                        BackgroundIconColor,
//                                        shape = RoundedCornerShape(10.dp)
//                                    )
//                                    .padding(10.dp),
//                                tint = MainColor
//                            )
//                            Text(
//                                text = "Daily\nGift",
//                                fontFamily = FontFamily(Font(R.font.regular_sf)),
//                                fontSize = 16.sp,
//                                textAlign = TextAlign.Center
//                            )
//                        }
//                        Column(
//                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            Icon(
//                                painter = painterResource(R.drawable.freeship_icon),
//                                contentDescription = "Free ship icon",
//                                modifier = Modifier
//                                    .size(50.dp)
//                                    .background(
//                                        BackgroundIconColor,
//                                        shape = RoundedCornerShape(10.dp)
//                                    )
//                                    .padding(10.dp),
//                                tint = MainColor
//                            )
//                            Text(
//                                text = "Free\nShip",
//                                fontFamily = FontFamily(Font(R.font.regular_sf)),
//                                fontSize = 16.sp,
//                                textAlign = TextAlign.Center
//                            )
//                        }
//                    }
//                }
                item {
                    CategoryUI(
                        navController = navController
                    )
                }
                item {
                    FlashSaleUI(
                        navController = navController
                    )
                }
                item {
                    BestSellerUI(
                        navController = navController
                    )
                }
            }
            BottomNavigationBarUI(
                navController = navController
            )
        }
    }
}

// Best seller UI
@Composable
fun BestSellerUI(
    navController: NavHostController,
    foodViewModel: FoodViewModel = viewModel()
) {
    val foodList = foodViewModel.state.value
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
        items(foodList.size) { index ->
            val food = foodList[index]
            BestSellerCardItem(
                imageUrl = food.imageUrl,
                cardItemName = food.name,
                cardItemPrice = food.price,
                contentDescription = "${food.name} Image",
                onBestSellerCardItemClick = {
                    navController.navigate("food-detail/${food.foodID}")
                }
            )
        }
    }
}

// Best Seller Card Item:
@Composable
fun BestSellerCardItem(
    imageUrl: String,
    cardItemName: String,
    cardItemPrice: Double,
    contentDescription: String,
    onBestSellerCardItemClick: () -> Unit
) {
    Column (
        modifier = Modifier
            .clickable { onBestSellerCardItemClick() }
    ){
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
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
            text = NumberFormat.getNumberInstance(Locale("vi", "VN")).format(cardItemPrice) + " VND",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.semibold_sf)),
            color = MainColor
        )
    }
}


// Flash Sale UI
@SuppressLint("DefaultLocale")
@Composable
fun FlashSaleUI(
    navController: NavHostController,
    flashSaleFoodViewModel: FlashSaleViewModel = viewModel()
) {
    val flashSaleFoodList = flashSaleFoodViewModel.state.value
    Log.d("Flash Sale List", "$flashSaleFoodList")
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
            tint = MainColor,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "FLASH SALE",
            fontFamily = FontFamily(Font(R.font.semibold_sf)),
            fontSize = 20.sp,
            color = MainColor,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = String.format("%02d:%02d:%02d", hours, minutes, seconds),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MainColor // Adjust color as needed
            )
        )
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(flashSaleFoodList.size) { index ->
            val food = flashSaleFoodList[index]
            FlashSaleCardItem(
                imageUrl = food.imageUrl,
                contentDescription = "${food.name} Image",
                cardItemName = food.name,
                originalPrice = food.price,
                salePrice = food.salePrice,
                onFlashSaleItemClick = {
                    navController.navigate("food-detail/${food.foodID}")
                }
            )
        }
    }
}

@Composable
fun CategoryCardItem(
    imageUrl: String,
    contentDescription: String,
    cardItemCategoryName: String,
    numberOfProducts: Int,
    onCategoryClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(280.dp)
            .height(150.dp)
            .padding(top = 15.dp)
            .clickable { onCategoryClick() }
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
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
fun FlashSaleCardItem(
    imageUrl: String,
    contentDescription: String,
    cardItemName: String,
    originalPrice: Double,
    salePrice: Double,
    onFlashSaleItemClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable { onFlashSaleItemClick() }
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
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
            text = NumberFormat.getNumberInstance(Locale("vi", "VN")).format(originalPrice) + " VND",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.regular_sf)),
            color = Color(0xFFBEC3C6),
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = NumberFormat.getNumberInstance(Locale("vi", "VN")).format(salePrice) + " VND",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.semibold_sf)),
            color = MainColor
        )
    }
}

@Composable
fun CategoryUI(
    categoryViewModel: CategoryViewModel = viewModel(),
    navController: NavHostController
) {
    val categoryList = categoryViewModel.state.value
    Log.d("Category", "$categoryList")
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
        items(categoryList.size) { index ->
            val category = categoryList[index]
            CategoryCardItem(
                imageUrl = category.imageUrl,
                contentDescription = category.description,
                cardItemCategoryName = category.name,
                numberOfProducts = 15,
                onCategoryClick = {
                    navController.navigate("food-list/${category.name}")
                }
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