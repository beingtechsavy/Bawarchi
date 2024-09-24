package com.example.bawarchi

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun searchResult(modifier:Modifier=Modifier,query:String){
    val recipeviewModel : searchViewModel= viewModel()
    val viewstate by recipeviewModel.searchState
    LaunchedEffect(query) {
        recipeviewModel.fetchSearch(query)  // Pass the query to the ViewModel
    }
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewstate.isLoading -> {
                CircularProgressIndicator(progress = 0.89f, modifier.align(
                    Alignment.Center))
            }

            viewstate.error != null -> {
                Column(modifier=Modifier.fillMaxSize().background(
                   color=Color(0xFFc9a436)), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = com.example.bawarchi.R.drawable.errormessage), // Replace with your image resource
                        contentDescription = "Error Message", // For accessibility
                        modifier = Modifier.fillMaxWidth(),
                        alignment = Alignment.Center,// Fill the available space
                        contentScale = ContentScale.Crop // Adjust image scaling
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(text = " ${viewstate.error} ", modifier=Modifier.padding(25.dp),color = Color(0xFFE0E0E0), textAlign = TextAlign.Center)
                }

            }

            else -> {

                    Log.d("part1","Successfully called part 1")
                     SearchItem(randomitem = viewstate.searchobject)
            }
        }
    }
}

@Composable
fun SearchItem(randomitem: List<Searchdat> ) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .border(
                border = BorderStroke(2.dp, Color.DarkGray),
                shape = RoundedCornerShape(8.dp)
            ).background(
               color=Color(0xFFc9a436)),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = randomitem[0].strMealThumb, error = painterResource(
                R.drawable.ic_call_decline)
            ),
            contentDescription = randomitem[0].strCategory     ,
            modifier= Modifier
                .wrapContentSize()
                .aspectRatio(1F)  ,

            )
        Text(
            text = randomitem[0].strMeal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = Color.White,
            fontSize = 32.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight(500)       ,
            textAlign = TextAlign.Center
        )
        YouTubeButton(youtubeLink = randomitem[0].strYoutube)
        Box(modifier = Modifier
            .padding(15.dp)
            .border(
                border = BorderStroke(
                    2.dp,
                    Color.Transparent

                ), shape = RoundedCornerShape(4.dp)
            )) {
            Text(text = randomitem[0].strInstructions, modifier = Modifier
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(8.dp), textAlign = TextAlign.Justify,
                color= Color.LightGray)
        }
    }
}

