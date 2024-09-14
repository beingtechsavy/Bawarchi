package com.example.bawarchi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import java.security.AccessController

@Composable
fun RecipeApp(navController: NavHostController){
         val recipeViewModel: MainViewModel= viewModel()
        val viewstate by recipeViewModel.categorieState
        NavHost(navController = navController, startDestination =Screen.LandingScreen.route ){
            composable(route=Screen.LandingScreen.route){
                MainScreen(navController = navController,navigateRecipe={
                    navController.navigate(Screen.RecipeScreen.route)
                },navigateRandom={navController.navigate(Screen.RandomScreen.route)})
            }
            composable(route=Screen.RandomScreen.route){
                RandomScreen(Modifier)
            }
            composable(route = Screen.RecipeScreen.route)   {
                        RecipeScreen(viewstate = viewstate , navigatetoDetail = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                        navController.navigate(Screen.DetailScreen.route)
                        })
            }
            composable(route= Screen.DetailScreen.route){
//              val category= navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")?: Category("","","","")
//                CategoryDetail(category = category)

                val category=navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")?: Category(" "," "," ","")
                CategoryDetail(category = category)
          }

      }
}
