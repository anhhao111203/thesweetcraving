package com.example.e_commerceapp.customize_objects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.viewmodel.NavigationViewModel

@Composable
fun NavigationItem(
    icon: Int,
    label: String,
    isSelect: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = onClick
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = "$label icon",
                tint = if (isSelect) Color(33, 166, 145) else Color(118,118,118),
                modifier = Modifier.size(30.dp)
            )
        }
        Text(
            text = label,
            fontSize = 15.sp,
            fontFamily = FontFamily(Font(R.font.regular_sf)),
            textAlign = TextAlign.Center,
            color = if (isSelect) Color(33, 166, 145) else Color(118,118,118),
        )
    }
}
@Composable
fun BottomNavigationBarUI(
    navController: NavHostController,
    navigationViewModel: NavigationViewModel = viewModel()
) {
    val selectedItem by navigationViewModel.selectedItem
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavigationItem(
            icon = R.drawable.user_icon,
            label = "Home",
            isSelect = selectedItem == "Translation",
            onClick = {
                navigationViewModel.selectItem("Translation")
                navController.navigate("translation")
            }
        )
        NavigationItem(
            icon = R.drawable.heart_icon,
            label = "Favorite",
            isSelect = selectedItem == "Favorite",
            onClick = {
                navigationViewModel.selectItem("Favorite")
                navController.navigate("favorites")
            }
        )
        NavigationItem(
            icon = R.drawable.notification_icon,
            label = "Notification",
            isSelect = selectedItem == "Alphabet",
            onClick = {
                navigationViewModel.selectItem("Alphabet")
                navController.navigate("morse_code_alphabet")
            }
        )
        NavigationItem(
            icon = R.drawable.user_icon,
            label = "Profile",
            isSelect = selectedItem == "Alphabet",
            onClick = {
                navigationViewModel.selectItem("Alphabet")
                navController.navigate("profile")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarUIPreview() {
    val navController = rememberNavController()
    BottomNavigationBarUI(navController)
}