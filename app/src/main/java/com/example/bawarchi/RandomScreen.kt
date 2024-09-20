package com.example.bawarchi

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter


@Composable
fun RandomScreen(modifier: Modifier = Modifier) {

    val recipeviewModel : RandomViewModel= viewModel()
    val viewstate by recipeviewModel.randomstate
    Box(modifier = Modifier.fillMaxSize().background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFFFA726), // Light Orange
                Color(0xFFFF5722)  // Dark Orange
            ),
            start = Offset(0f, 0f),
            end = Offset(1000f, 1000f)
        ))) {
        when {
            viewstate.isLoading -> {
                CircularProgressIndicator(progress = 0.89f, modifier.align(
                    Alignment.Center))
            }

            viewstate.error != null -> {
                Text(text = "Error! ${viewstate.error} ")
            }

            else -> {
                                    RandomItem(randomitem = viewstate.randomobject)
            }
        }
    }
}

//@Composable
//fun RandomScreen(categories: List<Random>) {
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//
//        modifier = Modifier.fillMaxSize()
//    )   {
//        items(categories)         {
//                random ->
//            RandomItem(items = random)
//        }
//    }
//}


@Composable
fun RandomItem(randomitem: List<Random> ) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .border(
                border = BorderStroke(2.dp, Color.DarkGray),
                shape = RoundedCornerShape(8.dp)
            ),
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
            color = Color.LightGray,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight(500)       ,
            textAlign = TextAlign.Center
        )
         YouTubeButton(youtubeLink = randomitem[0].strYoutube)
        Box(modifier = Modifier.padding(15.dp).border(border = BorderStroke(2.dp,
            Color.DarkGray))) {
            Text(text = randomitem[0].strInstructions, modifier = Modifier.verticalScroll(
                rememberScrollState()
            ).padding(8.dp),color = Color.White, textAlign = TextAlign.Justify)
        }
    }
}

@Composable
fun YouTubeButton(youtubeLink: String) {
    val context = LocalContext.current
    Button(onClick = {
        val uri = Uri.parse(youtubeLink)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(intent)
    },colors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF008080),
        contentColor = Color.White
    ), shape = RoundedCornerShape(8.dp)) {
        Text(text = " Watch on Youtube ", color = Color.White, modifier = Modifier.background(
            Color.Red))
    }
}