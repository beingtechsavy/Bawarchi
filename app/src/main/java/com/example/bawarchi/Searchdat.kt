package com.example.bawarchi

data class Searchdat(
    val idMeal:String,
    val strMeal:String,
    val strCategory:String,
    val strArea: String,
    val strMealThumb:String,
    val strYoutube:String,
    val strInstructions:String
)
data class SearchResponse(val meals:List<Searchdat>)