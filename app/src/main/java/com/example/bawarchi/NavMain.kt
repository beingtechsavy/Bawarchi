package com.example.bawarchi

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

//@Composable
//fun navMain(navController: NavController,modifier: Modifier){
//    val Bawarchi = FontFamily(
//        Font(R.font.sofadi) // Load your font directly
//    )
//    Column {
//
//
//        Column {
//            Text(
//                text = "Bawarchi",
//                fontFamily = Bawarchi,
//                fontSize = 40.sp, modifier = Modifier
//                    .padding(20.dp)
//                    .fillMaxWidth(),
//                textAlign = TextAlign.Center
//            )
//
//            Image(
//                painter = painterResource(id = R.drawable.thumbnail), // Replace with your image resource
//                contentDescription = "Thumbnail", // For accessibility
//                modifier = Modifier.fillMaxWidth(),
//                alignment = Alignment.Center,// Fill the available space
//                contentScale = ContentScale.Crop // Adjust image scaling
//            )
//        }
//
//               Spacer(modifier = Modifier.height(20.dp))
//
//
//        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
//            Button(onClick = {
//                navController.navigate("first_screen")
//            }) {
//                Text(
//                    text = "Explore Categories",
//                    fontFamily = Bawarchi
//                )
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = {
//                navController.navigate("second_screen")
//            }) {
//                Text(text = "Random Recipe", fontFamily = Bawarchi)
//            }
//        }
//
//    }
//
//
//}
//
//@Composable
//fun MynavHost(){
//    val navController= rememberNavController()
//    NavHost(navController, startDestination = "first_screen") {
//        composable("first_screen") {
//            RecipeApp(navController = navController)
//        }
//        composable("second_screen") {
//            RandomScreen(modifier = Modifier)
//        }
//    }
//}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController,navigateSearch:(String) -> Unit ,navigateRecipe: (Unit) -> Unit ,navigateRandom: (Unit) -> Unit) {
    val Bawarchi = FontFamily(
        Font(R.font.sofadi) // Load your font directly
    )
    val context= LocalContext.current
    val searchview:searchViewModel= viewModel()
     var searchQuery by remember { mutableStateOf("")}         
    Column (modifier = Modifier
        .fillMaxSize()
        .background(
            color = Color(0xFFc9a436)
        )){
        Column {
            Text(
                text = "Bawarchi",
                fontFamily = Bawarchi,
                fontSize = 40.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

           
//            OutlinedTextField(
//                value = searchQuery,
//                shape = RoundedCornerShape(8.dp),
//               textStyle = TextStyle(color= Color.White, fontWeight = FontWeight(700)),
//                onValueChange = { newValue -> searchQuery = newValue },
//                label = { Text("Search for a meal") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp),
//                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color(0xFF008080), focusedTrailingIconColor = Color(0xFF008080)),
//                trailingIcon = {
//                    IconButton(onClick = { /* Trigger the search */
//                        if (searchQuery.isNotBlank()) {
//                            navigateSearch(searchQuery)
//                        }
////                        else{
////                            Toast.makeText(context,"Blank Search",Toast.LENGTH_SHORT)
////                        }
//                    }) {
//                        Icon(Icons.Default.Search, contentDescription = "Search")
//                    }
//                },
//                singleLine = true
//            )
            




            Image(
                painter = painterResource(id = R.drawable.thumbnail), // Replace with your image resource
                contentDescription = "Thumbnail", // For accessibility
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.Center,// Fill the available space
                contentScale = ContentScale.Crop // Adjust image scaling
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = searchQuery,
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(color= Color.White, fontWeight = FontWeight(700)),
            onValueChange = { newValue -> searchQuery = newValue },
            label = { Text("Search for a meal", color = Color.White) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color(0xFF365BC9), focusedTrailingIconColor = Color(0xFF365BC9)),
            trailingIcon = {
                IconButton(onClick = { /* Trigger the search */
                    if (searchQuery.isNotBlank()) {
                        navigateSearch(searchQuery)
                    }
//                        else{
//                            Toast.makeText(context,"Blank Search",Toast.LENGTH_SHORT)
//                        }
                }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
            },
            singleLine = true
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { navigateRecipe(Unit) },colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF365BC9),
                contentColor = Color.White
            )) {
                Text(
                    text = "Browse Recipes",
                    color = Color.White,
                    fontFamily = Bawarchi
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navigateRandom(Unit) }, colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF365BC9),
                contentColor = Color.White
            )) {
                
                Text(text = "Random Recipe",
                    color = Color.White,fontFamily = Bawarchi)
            }
        }
    }
}

