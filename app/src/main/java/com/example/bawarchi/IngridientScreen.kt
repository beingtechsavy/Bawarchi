package com.example.bawarchi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun IngridientScreen(modifier: Modifier) {
    val recipeviewModel: MainViewModel = viewModel()
    val viewstate by recipeviewModel.ingridientState
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewstate.isLoading -> {
                CircularProgressIndicator(
                    progress = 0.89f, modifier.align(
                        Alignment.Center
                    )
                )
            }

            viewstate.error != null -> {
                Text(text = "Error! ")
            }

            else -> {
                IngridientsScreen(ingridients = viewstate.list)
            }
        }
    }
}


@Composable
fun IngridientsScreen(ingridients: List<Ingredients>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),

        modifier = Modifier.fillMaxSize()
    ) {
        items(ingridients) { Ingridient ->
            IngridientItem(ingridient = Ingridient)
        }
    }
}

@Composable
fun IngridientItem(ingridient: Ingredients) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable {

            }
            .border(
                border = BorderStroke(2.dp, Color.DarkGray),
                shape = RoundedCornerShape(8.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = ingridient.strIngredients,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            color = Color.DarkGray,
            fontSize = 32.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight(500)
        )


    }
}