package com.example.bawarchi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier, viewstate: MainViewModel.RecipeState ,navigatetoDetail: (Category) -> Unit) {
    
    Box(modifier = Modifier.fillMaxSize().background(
        color=Color(0xFFc9a436))) {
        when {
            viewstate.isLoading -> {
                CircularProgressIndicator(progress = 0.89f, modifier.align(Alignment.Center))
            }

            viewstate.error != null -> {
                Text(text = "Error! ")
            }

            else -> {
                    CategoryScreen(categories = viewstate.list,navigatetoDetail)
            }
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>,navigatetoDetail: (Category) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),

        modifier = Modifier.fillMaxSize()
    )   {
        items(categories)         {
               category ->
            CategoryItem(category = category, navigatetoDetail)
        }
    }
}


@Composable
fun CategoryItem(category: Category   ,
        navigatetoDetail: (Category) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize().clickable {
                navigatetoDetail(category)
            }.border(border = BorderStroke(2.dp, Color(0xFF365BC9)), shape = RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb, error = painterResource(
                androidx.core.R.drawable.ic_call_decline)),
            contentDescription = category.strCategory     ,
            modifier= Modifier
                .fillMaxSize()
                .aspectRatio(1F)  ,

        )
        Text(
            text = category.strCategory,
            color = Color.White,
            style = TextStyle(fontWeight = FontWeight(500)),
            modifier = Modifier.padding(top = 5.dp, bottom = 4.dp)
        )

    }
}