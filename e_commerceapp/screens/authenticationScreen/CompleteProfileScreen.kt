package com.example.e_commerceapp.screens.authenticationScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.e_commerceapp.R
import com.example.e_commerceapp.customize_objects.CustomizeTextField
import com.example.e_commerceapp.customize_objects.HeaderBar
import com.example.e_commerceapp.ui.theme.MainColor
import com.example.e_commerceapp.viewmodel.CompleteProfileViewModel

@Composable
fun CompleteProfileScreen(
    navController: NavHostController,
    userID: String,
    completeProfileViewModel: CompleteProfileViewModel = viewModel(),
) {
    // mutable variables to save the user's input
    var accountName by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var phoneNumber by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var address by remember {
        mutableStateOf(TextFieldValue(""))
    }
    // immutable variables to save the error state of user's input
    val accountNameErrorState = remember {
        mutableStateOf(false)
    }
    val phoneNumberErrorState = remember {
        mutableStateOf(false)
    }
    val addressErrorState = remember {
        mutableStateOf(false)
    }

    // For check box state:
    var isChecked by remember{
        mutableStateOf(false)
    }
    // UI design
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderBar(
                label = "Complete Profile",
                onPreviousClick = {}
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Complete Profile",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.semibold_sf)),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Please enter all required information to complete signing up your account",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.regular_sf)),
                    color = Color.LightGray,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f),
                verticalArrangement = Arrangement.spacedBy(space = 20.dp, alignment = Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomizeTextField(
                    placeholder = "Enter your name",
                    trailingIcon = R.drawable.user,
                    label = "Account Name",
                    keyboardType = KeyboardType.Text,
                    visualTransformation = VisualTransformation.None,
                    errorState = accountNameErrorState,
                    onChanged = { newInputAccountName -> accountName = newInputAccountName }
                )
                CustomizeTextField(
                    placeholder = "Enter your phone number",
                    trailingIcon = R.drawable.phone,
                    label = "Phone number",
                    keyboardType = KeyboardType.Phone,
                    visualTransformation = VisualTransformation.None,
                    errorState = phoneNumberErrorState,
                    onChanged = { newInputPhoneNumber -> phoneNumber = newInputPhoneNumber }
                )
                CustomizeTextField(
                    placeholder = "Enter your address",
                    trailingIcon = R.drawable.address,
                    label = "Address",
                    keyboardType = KeyboardType.Text,
                    visualTransformation = VisualTransformation.None,
                    errorState = addressErrorState,
                    onChanged = { newInputAddress -> address = newInputAddress }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = {checked ->
                            isChecked = checked
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = MainColor
                        )
                    )
                    Text(
                        text = buildAnnotatedString {
                            append(text = "Confirm that you read and agree with our ")
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    color = MainColor,
                                )
                            ) {
                                append("Terms & Condition")
                            }
                        },
                        color = Color.LightGray,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.regular_sf))
                    )
                }
            }
            Spacer(modifier = Modifier.weight(0.1f))
            Button(
                onClick = {
                          completeProfileViewModel.saveUserProfile(
                              userID = userID,
                              accountName = accountName.text,
                              phoneNumber = phoneNumber.text,
                              address = address.text,
                              onSuccess = {
                                  navController.navigate("home-page")
                              },
                              onError = {}
                          )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Complete",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.semibold_sf))
                )
            }
            Spacer(modifier = Modifier.weight(0.1f))
        }
    }
}

@Preview (showBackground = true)
@Composable
fun CompleteProfileScreenPreview() {
    val navController = rememberNavController()
    CompleteProfileScreen(navController, "1")
}
