package com.example.e_commerceapp.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.dataClass.Category
import com.example.e_commerceapp.dataClass.Food
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class FlashSaleViewModel: ViewModel() {
    val state = mutableStateOf<List<Food>>(listOf())

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            state.value = getFlashSaleFoodFromFireStore()
        }
    }

    fun getDetailByFoodID(foodID: String): Food? {
        val foodList = state.value

        // Log the input to verify what you're searching for
        Log.d("FoodDetail", "Searching for food with ID: '$foodID'")

        // Logging the food list to check what's being stored
        Log.d("FoodList", "Current food list: $foodList")

        val foundFood = foodList.find { it.foodID.equals(foodID, ignoreCase = true) }

        if (foundFood == null) {
            Log.d("FoodDetail", "No food found with ID: '$foodID'")
        } else {
            Log.d("FoodDetail", "Found food: $foundFood")
        }

        return foundFood
    }

}
class FoodViewModel: ViewModel() {
    val state = mutableStateOf<List<Food>>(listOf())

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }

    fun getFoodByCategory(categoryName: String): List<Food> {
        return state.value.filter { it.category == categoryName }
    }

}
class CategoryViewModel: ViewModel() {
    val state = mutableStateOf<List<Category>>(listOf())

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            state.value = getCategoryFromFireStore()
        }
    }
}

suspend fun getCategoryFromFireStore(): List<Category> {
    val db = FirebaseFirestore.getInstance()
    val categoryList = mutableListOf<Category>()

    try{
        val snapshot = db.collection("category")
            .get()
            .await()

        for (document in snapshot) {
            val category = document.toObject(Category::class.java)
            categoryList.add(category)
        }
    }
    catch (e: FirebaseFirestoreException) {
        Log.d("error", "getCategoryFromFireStore: $e")
    }

    return categoryList
}
suspend fun getFlashSaleFoodFromFireStore(): List<Food>{
    val db = FirebaseFirestore.getInstance()
    val flashSaleFoodList = mutableListOf<Food>()

    try {
        val snapshot = db.collection("foods")
            .whereEqualTo("isFlashSale", true)
            .get()
            .await()

        for (document in snapshot) {
            val flashSaleFood = document.toObject(Food::class.java)
            flashSaleFood.foodID = document.id
            flashSaleFoodList.add(flashSaleFood)
        }
    }
    catch (e: FirebaseFirestoreException) {
        Log.d("error", "getFlashSaleDataFromFireStore: $e")
    }

    return flashSaleFoodList
}

suspend fun getDataFromFireStore(): List<Food>{
    val db = FirebaseFirestore.getInstance()
    val foodList = mutableListOf<Food>()

    try {
        val snapshot = db.collection("foods")
            .get()
            .await()
        for (document in snapshot) {
            val food = document.toObject(Food::class.java)
            food.foodID = document.id
            foodList.add(food)
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("error", "getDataFromFireStore: $e")
    }

    return foodList
}