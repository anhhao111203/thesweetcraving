package com.example.e_commerceapp

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartUI() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                item {
                    CardItem(
                        itemName = "Matcha Tiramisu",
                        itemCategory = "Tiramisu",
                        itemPrice = "55.000",
                        itemQuantity = 2.toString(),
                        itemImageID = R.drawable.matcha_tiramisu,
                        itemContentDescription = "Matcha Tiramisu Image"
                    )
                }
                item {
                    CardItem(
                        itemName = "Chocolate Tiramisu",
                        itemCategory = "Tiramisu",
                        itemPrice = "50.000",
                        itemQuantity = 3.toString(),
                        itemImageID = R.drawable.chocolate_tiramisu,
                        itemContentDescription = "Chocolate Tiramisu Image"
                    )
                }
                item {
                    CardItem(
                        itemName = "Triple Berry Tiramisu",
                        itemCategory = "Tiramisu",
                        itemPrice = "60.000",
                        itemQuantity = 1.toString(),
                        itemImageID = R.drawable.triple_berry_tiramisu,
                        itemContentDescription = "Triple Berry Tiramisu Image"
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            DashedLine()
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Subtotal",
                        fontFamily = FontFamily(Font(R.font.regular_sf)),
                        color = Color.Black.copy(alpha = 0.5f),
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "155.000 VND",
                        fontFamily = FontFamily(Font(R.font.regular_sf)),
                        color = Color.Black.copy(alpha = 0.5f),
                        fontSize = 18.sp
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Shipping fee",
                        fontFamily = FontFamily(Font(R.font.regular_sf)),
                        color = Color.Black.copy(alpha = 0.5f),
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "15.000 VND",
                        fontFamily = FontFamily(Font(R.font.regular_sf)),
                        color = Color.Black.copy(alpha = 0.5f),
                        fontSize = 18.sp
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Total",
                        fontFamily = FontFamily(Font(R.font.semibold_sf)),
                        color = Color(33, 166, 145),
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "170.000 VND",
                        fontFamily = FontFamily(Font(R.font.semibold_sf)),
                        color = Color(33, 166, 145),
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}
@Composable
fun DashedLine() {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
    ) {
        drawLine(
            color = Color.Black.copy(alpha = 0.5f),
            start = androidx.compose.ui.geometry.Offset(0f, 0f),
            end = androidx.compose.ui.geometry.Offset(size.width, 0f),
            strokeWidth = 4f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        )
    }
}

@Composable
fun CardItem(
    itemName: String,
    itemCategory: String,
    itemPrice: String,
    itemQuantity: String,
    itemImageID: Int,
    itemContentDescription: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = itemImageID),
            contentDescription = itemContentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .size(100.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = itemName,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.semibold_sf)),
                color = Color(33, 166, 145)
            )
            Text(
                text = itemCategory,
                fontSize = 15.sp,
                color = Color.Black.copy(alpha = 0.5f),
                fontFamily = FontFamily(Font(R.font.regular_sf))
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "$itemPrice VND",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.semibold_sf))
                )
                Spacer(modifier = Modifier.weight(1f))
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
                    text = itemQuantity,
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
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartUIPreview() {
    CartUI()
}