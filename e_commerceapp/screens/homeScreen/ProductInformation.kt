package com.example.e_commerceapp.screens.homeScreen

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.e_commerceapp.R
import com.example.e_commerceapp.viewmodel.CartViewModel
import com.example.e_commerceapp.viewmodel.FlashSaleViewModel
import java.text.NumberFormat
import java.util.Locale


@Composable
fun ProductInformationUI(
    foodID: String,
    foodViewModel: FlashSaleViewModel = viewModel(),
) {
    val foodSelected = foodViewModel.getDetailByFoodID(foodID)
    val cartViewModel = CartViewModel()

    var quantity by remember {
        mutableIntStateOf(1)
    }
    
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
                if (foodSelected != null) {
                    Image(
                        painter = rememberAsyncImagePainter(model = foodSelected.imageUrl),
                        contentDescription = "Matcha Tiramisu Image",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                }
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
                        if (foodSelected != null) {
                            Text(
                                text = foodSelected.name,
                                fontFamily = FontFamily(Font(R.font.semibold_sf)),
                                fontSize = 20.sp
                            )
                        }
                        if (foodSelected != null) {
                            Text(
                                text = NumberFormat.getNumberInstance(Locale("vi", "VN")).format(foodSelected.price) + " VND",
                                fontFamily = FontFamily(Font(R.font.semibold_sf)),
                                fontSize = 22.sp,
                                color = Color(33, 166, 145)
                            )
                        }
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
                if (foodSelected != null) {
                    Text(
                        text = foodSelected.description,
                        fontFamily = FontFamily(Font(R.font.regular_sf)),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Justify,
                        color = Color.Black.copy(alpha = 0.5f),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
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
                            .clickable {
                                       if(quantity > 1) {
                                           quantity--
                                       }
                            },
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
                        text = quantity.toString(),
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
                            .clickable {
                                       quantity++
                            },
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
                        onClick = {
                            if(foodSelected != null) {
                                cartViewModel.addToCart(
                                    foodID = foodSelected.foodID,
                                    foodName = foodSelected.name,
                                    price = foodSelected.price,
                                    quantity = quantity,
                                    imageUrl = foodSelected.imageUrl,
                                    onSuccess = {},
                                    onFailure = {}
                                )
                            }
                        },
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
    ProductInformationUI(
        foodID = "Demo"
    )
}