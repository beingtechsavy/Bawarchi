package com.example.bawarchi

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class searchViewModel: ViewModel() {
    private val _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _searchState

//    init {
////        fetchCategories()
////        fetchIngredients()
//        fetchSearch("Arrabiata")
//    }

    fun fetchSearch(query:String){
        viewModelScope.launch {
            try {
                
                val response = recipeService.getSearch(query)

                // Add a null check for response.random
                val searchList = response.meals //Provide a default value if null

                _searchState.value = _searchState.value.copy(
                    searchobject = searchList,
                    isLoading = false,
                    error = null
                )

                Log.d(
                    "Random",
                    "Categories fetched: ${response.meals}"
                )

            } catch (e: Exception) {
                _searchState.value = _searchState.value.copy(
                    isLoading = false,
                    error = " Recipe Not availiable. We will have it Soon :)"
                )
            }
        }

    }

    data class SearchState(
        val isLoading: Boolean = true,
        val searchobject: List<Searchdat> = emptyList(),
        val error: String? = null,
    )
}