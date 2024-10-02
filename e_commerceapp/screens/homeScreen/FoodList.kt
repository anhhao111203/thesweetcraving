package com.example.e_commerceapp.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.e_commerceapp.R
import com.example.e_commerceapp.viewmodel.FoodViewModel
import java.text.NumberFormat
import java.util.Locale

@Composable
fun FoodListUI(
    categoryName: String,
    foodViewModel: FoodViewModel = viewModel()
) {
    val foodList = foodViewModel.getFoodByCategory(categoryName)
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
                    .weight(0.3f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.matcha_tiramisu),
                    contentDescription = "Matcha Tiramisu Image",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.weight(0.7f),
            ) {
                Text(
                    text = categoryName,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.semibold_sf)),
                    modifier = Modifier
                        .padding(15.dp)
                        .align(alignment = Alignment.Start)
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(foodList.size) { index ->
                        val food = foodList[index]
                        FoodCard(
                            imageUrl = food.imageUrl,
                            name = food.name,
                            price = food.price
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FoodCard(
    imageUrl: String,
    name: String,
    price: Double
) {
    Row {
        Image(
            painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = "Matcha tiramisu",
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(150.dp),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .padding(start = 15.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.regular_sf)),
                modifier = Modifier.padding(top = 6.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(
                    text = "13 sold",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    color = Color.Black.copy(alpha = 0.5f)
                )
                Text(
                    text = "5 likes",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    color = Color.Black.copy(alpha = 0.5f)
                )
            }
            Text(
                text = NumberFormat.getNumberInstance(Locale("vi", "VN")).format(price) + " VND",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.semibold_sf)),
                color = Color(33, 166, 145)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.add_to_cart),
            contentDescription = "Add to cart",
            tint = Color(33, 166, 145),
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Bottom)
        )
    }
}

@Preview (showBackground = true)
@Composable
fun FoodListUIPreview() {
    FoodListUI(
        categoryName = "Demo"
    )
}
