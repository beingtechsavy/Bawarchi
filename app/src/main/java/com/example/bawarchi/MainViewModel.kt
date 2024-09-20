package com.example.bawarchi

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _CategorieState = mutableStateOf(RecipeState())
    val categorieState: State<RecipeState> = _CategorieState

  

    private val _randomState = mutableStateOf(RandomState())
    val randomstate: State<RandomState> = _randomState

    init {
        fetchCategories()
//        fetchIngredients()
//        fetchRandom()
    }


    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _CategorieState.value = _CategorieState.value.copy(
                    list = response.categories,
                    isLoading = false,
                    error = null
                )
                Log.d(
                    "RecipeApp",
                    "Categories fetched: ${response.categories}"
                )

            } catch (e: Exception) {
                _CategorieState.value = _CategorieState.value.copy(
                    isLoading = false,
                    error = "Error fetching Categories : We will Add it Soon :) "
                )

            }
        }
    }

//    private fun fetchIngredients() {
//        viewModelScope.launch {
//            try {
//                val response = recipeService.getIngredients()
//                _ingridientState.value = _ingridientState.value.copy(
//                    list = response.ingredients,
//                    isLoading = false,
//                    error = null
//                )
//                Log.d(
//                    "Ingridients",
//                    "Ingridients Fetched: ${response.ingredients}"
//                )
//
//
//            } catch (e: Exception) {
//                _ingridientState.value = _ingridientState.value.copy(
//                    isLoading = false,
//                    error = "error fetching Categories: ${e.message}"
//                )
//            }
//        }
//    }

    data class RecipeState(
        val isLoading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null,
    )



    data class RandomState(
        val isLoading: Boolean = true,
        val list: List<Random> = emptyList(),
        val error: String? = null,
    )

}