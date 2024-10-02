package com.example.e_commerceapp.screens.homeScreen

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.e_commerceapp.R
import com.example.e_commerceapp.viewmodel.CartViewModel

@Composable
fun CartUI(
    cartViewModel: CartViewModel = viewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Column {
            ContactInformation(
                orderName = "Anh Hào",
                orderPhone = "0969247870",
                orderAddress = "Cu Chi District, Ho Chi Minh City"
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                item {
                    CartItemList()
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Note",
                            fontFamily = FontFamily(Font(R.font.regular_sf)),
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Give me a note",
                            fontFamily = FontFamily(Font(R.font.regular_sf)),
                            color = Color.Black.copy(alpha = 0.5f),
                            fontSize = 18.sp
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.next_icon),
                            contentDescription = "Next icon",
                            tint = Color.Black.copy(alpha = 0.5f),
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    DealForUser()
                    Spacer(modifier = Modifier.height(30.dp))
                    DashedLine()
                    Spacer(modifier = Modifier.height(30.dp))
                    AmountMoneyToPay()
                    Spacer(modifier = Modifier.height(30.dp))
                    PaymentMethod()
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(33, 166, 145)
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Complete",
                            fontFamily = FontFamily(Font(R.font.semibold_sf)),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun CartItemList(
    cartViewModel: CartViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.Start
    ) {
        CardItem(
            itemName = "Matcha Tiramisu",
            itemCategory = "Tiramisu",
            itemPrice = "55.000",
            itemQuantity = 2.toString(),
            itemImageID = R.drawable.matcha_tiramisu,
            itemContentDescription = "Matcha Tiramisu Image"
        )
        CardItem(
            itemName = "Matcha Tiramisu",
            itemCategory = "Tiramisu",
            itemPrice = "55.000",
            itemQuantity = 2.toString(),
            itemImageID = R.drawable.matcha_tiramisu,
            itemContentDescription = "Matcha Tiramisu Image"
        )
        CardItem(
            itemName = "Matcha Tiramisu",
            itemCategory = "Tiramisu",
            itemPrice = "55.000",
            itemQuantity = 2.toString(),
            itemImageID = R.drawable.matcha_tiramisu,
            itemContentDescription = "Matcha Tiramisu Image"
        )
    }
}

@Composable
fun AmountMoneyToPay() {
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
fun PaymentMethod() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(33, 166, 145).copy(alpha = 0.1f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp)
            .clickable { }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Payment Method",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.semibold_sf)),
                color = Color.Black
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.money_icon),
                    contentDescription = "By cash icon",
                    tint = Color(33, 166, 145),
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text = "By cash",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    color = Color.Black.copy(alpha = 0.5f),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(
                    checked = true,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(33, 166, 145),
                        uncheckedColor = Color(33, 166, 145)
                    ),
                    modifier = Modifier.clip(shape = CircleShape)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.credit_card_icon),
                    contentDescription = "By cash icon",
                    tint = Color(33, 166, 145),
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text = "VNPay",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    color = Color.Black.copy(alpha = 0.5f),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(
                    checked = false,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(33, 166, 145),
                        uncheckedColor = Color.Black.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier.clip(shape = CircleShape)
                )
            }
        }
    }
}

@Composable
fun ContactInformation(
    orderName: String,
    orderPhone: String,
    orderAddress: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = Color(33, 166, 145).copy(alpha = 0.2f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.address_icon),
                    contentDescription = "Address icon",
                    tint = Color(33, 166, 145),
                    modifier = Modifier.size(20.dp)
                )
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Row {
                        Text(
                            text = orderName,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.semibold_sf)),
                            color = Color(33, 166, 145)
                        )
                        Text(
                            text = orderPhone,
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.regular_sf)),
                            color = Color.Black.copy(alpha = 0.5f),
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                    Text(
                        text = orderAddress,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.regular_sf)),
                        color = Color.Black.copy(alpha = 0.5f)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.next_icon),
                    contentDescription = "Next icon",
                    tint = Color(33, 166, 145),
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun DealForUser() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = Color(33, 166, 145).copy(alpha = 0.1f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(15.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            painter = painterResource(id = R.drawable.deal_icon),
            contentDescription = "Deal icon",
            tint = Color(33, 166, 145),
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            "Voucher",
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.semibold_sf)),
            color = Color.Black,
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Free Ship",
            fontFamily = FontFamily(Font(R.font.regular_sf)),
            color = Color(33, 166, 145),
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic
        )
        Icon(
            painter = painterResource(id = R.drawable.next_icon),
            contentDescription = "Next icon",
            tint = Color(33, 166, 145),
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterVertically)
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