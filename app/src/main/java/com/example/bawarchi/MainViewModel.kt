package com.example.bawarchi

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val _CategorieState= mutableStateOf(RecipeState())
    val categorieState : State<RecipeState> = _CategorieState

    init {
        fetchCategories()
    }


    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response= recipeService.getCategories()
                _CategorieState.value=_CategorieState.value.copy(list = response.categories, isLoading = false, error = null)
                Log.d("RecipeApp", "Categories fetched: ${response.categories}")

            } catch (e: Exception) {
                          _CategorieState.value=_CategorieState.value.copy(isLoading = false,
                              error="Error fetching Categories : ${e.message}")
            }
        }
    }


    data class RecipeState(val isLoading:Boolean=true,val list: List<Category> = emptyList(),val error:String?=null)
}