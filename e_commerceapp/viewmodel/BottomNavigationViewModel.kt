package com.example.e_commerceapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NavigationViewModel: ViewModel() {
    private val _selectedItem = mutableStateOf("Translation")

    val selectedItem: State<String> = _selectedItem

    fun selectItem(item: String) {
        _selectedItem.value = item
    }

}