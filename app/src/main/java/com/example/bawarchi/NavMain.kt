package com.example.bawarchi

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
@Composable
fun MainScreen(navController: NavController,navigateRecipe: (Unit) -> Unit ,navigateRandom: (Unit) -> Unit) {
    val Bawarchi = FontFamily(
        Font(R.font.sofadi) // Load your font directly
    )

    Column {
        Column {
            Text(
                text = "Bawarchi",
                fontFamily = Bawarchi,
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.thumbnail), // Replace with your image resource
                contentDescription = "Thumbnail", // For accessibility
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.Center,// Fill the available space
                contentScale = ContentScale.Crop // Adjust image scaling
            )
        }

        Spacer(modifier = Modifier.height(20.dp))


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { navigateRecipe(Unit) }) {
                Text(
                    text = "Explore Categories",
                    fontFamily = Bawarchi
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navigateRandom(Unit) }) {
                Text(text = "Random Recipe", fontFamily = Bawarchi)
            }
        }
    }
}

