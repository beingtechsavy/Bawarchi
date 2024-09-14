package com.example.bawarchi

sealed class Screen(val route:String) {
    object  RecipeScreen:Screen("recipescreen")
    object  DetailScreen: Screen("detailscreen")

    object RandomScreen: Screen("randomscreen")
    object LandingScreen: Screen("landingpage")
}