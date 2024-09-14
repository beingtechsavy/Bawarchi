package com.example.bawarchi

data class Random(
    val idMeal:String,
    val strMeal:String,
    val strCategory:String,
    val strArea: String,
    val strMealThumb:String,
    val strYoutube:String,
    val strInstructions:String
)
data class RandomResponse(val meals:List<Random>)
