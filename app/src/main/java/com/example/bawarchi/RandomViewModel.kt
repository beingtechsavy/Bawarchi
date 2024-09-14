package com.example.bawarchi

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RandomViewModel : ViewModel() {



    private val _randomState = mutableStateOf(RandomState())
    val randomstate: State<RandomState> = _randomState

    init {
//        fetchCategories()
//        fetchIngredients()
        fetchRandom()
    }

    private fun fetchRandom(){
        viewModelScope.launch {
            try {
                val response = recipeService.getRandom()

                // Add a null check for response.random
                val randomList = response.meals //Provide a default value if null

                _randomState.value = _randomState.value.copy(
                    randomobject = randomList,
                    isLoading = false,
                    error = null
                )

                Log.d(
                     "Random",
                    "Categories fetched: ${response.meals}"
                )

            } catch (e: Exception) {
                _randomState.value = _randomState.value.copy(
                    isLoading = false,
                    error = "Error fetching Categories : ${e.message}"
                )
            }
        }

    }

    data class RandomState(
        val isLoading: Boolean = true,
        val randomobject: List<Random> = emptyList(),
        val error: String? = null,
    )

}