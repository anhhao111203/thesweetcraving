package com.example.e_commerceapp.customize_objects

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerceapp.R

@Composable
fun HeaderBar(
    label: String,
    onPreviousClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.previous) ,
            contentDescription = "Previous icon",
            modifier = Modifier
                .size(40.dp)
                .weight(0.1f)
                .clickable { onPreviousClick() },
            tint = Color.Black
        )
        Text(
            text = label,
            fontSize = 18.sp,
            color = Color(0xFFBEC3C6),
            modifier = Modifier.weight(0.9f),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.regular_sf))
        )
    }
}