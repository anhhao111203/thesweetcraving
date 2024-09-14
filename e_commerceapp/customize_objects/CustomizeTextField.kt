package com.example.e_commerceapp.customize_objects

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.e_commerceapp.R


@Composable
fun CustomizeTextField(
    placeholder: String,
    trailingIcon: Int,
    label: String,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation,
    errorState: MutableState<Boolean>,
    onChanged: (TextFieldValue) -> Unit
) {
    var inputText by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = inputText,
        onValueChange = { newInputText ->
            inputText = newInputText
            onChanged(newInputText)
        },
        placeholder = { Text(text = placeholder) },
        trailingIcon = {
            Icon(
                painter = painterResource(id = trailingIcon),
                contentDescription = null,
            )
        },
        singleLine = true,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        isError = errorState.value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        shape = RoundedCornerShape(1.dp),
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.regular_sf))
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(33, 166, 145),
            focusedLabelColor = Color(33, 166, 145),
            cursorColor = Color(33, 166, 145),
            errorBorderColor = Color.Red
        )
    )
}