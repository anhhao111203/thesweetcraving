package com.example.e_commerceapp.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.ui.theme.LightBlack
import com.example.e_commerceapp.ui.theme.MainColor


@Composable
fun Profile(
    navController: NavHostController
) {
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
                    .weight(0.2f)
                    .background(
                        color = MainColor,
                        shape = RoundedCornerShape(bottomEndPercent = 20, bottomStartPercent = 20)
                    )
            )
            Box(
                modifier = Modifier
                    .weight(0.8f)
                    .background(
                        color = Color.White
                    ),
                contentAlignment = Alignment.TopCenter
            ) {
                ProfileHeader()
                Box(
                    modifier = Modifier.offset(y = (-100).dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.male_avatar),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .offset(y = (-50).dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Anh Hào",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.semibold_sf))
            )
            Text(
                text = "anhhao@gmail.com",
                color = LightBlack,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.regular_sf))
            )
            Spacer(modifier = Modifier.height(30.dp))
            ProfileOptions()
        }
    }
}

@Composable
fun ProfileOptions() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        val options = listOf(
            "Account" to R.drawable.user_icon,
            "Help" to R.drawable.ask_for_help_icon,
            "Sign out" to R.drawable.sign_out_icon
        )
        options.forEach { (title, icon) ->
            ProfileOptionItem(title = title, iconId = icon)
        }
    }
}

@Composable
fun ProfileOptionItem(
    title: String,
    iconId: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = "Option Icon",
            modifier = Modifier.size(24.dp),
            tint = LightBlack
        )
        Text(
            text = title,
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.semibold_sf)),
            color = LightBlack
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.next_icon),
            contentDescription = "Option Icon",
            modifier = Modifier.size(24.dp),
            tint = LightBlack
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()
    Profile(navController)
}