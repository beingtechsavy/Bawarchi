package com.example.bawarchi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryDetail(category: Category){
    Column(modifier = Modifier.fillMaxSize().background(
        color=Color(0xFFc9a436)), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = category.strCategory, modifier = Modifier.padding(8.dp), textAlign = TextAlign.Center, fontSize = 25.sp, fontWeight = FontWeight(500))
        Image(
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb
            ),
            contentDescription = category.strCategory     ,
            modifier= Modifier
                .wrapContentSize()
                .aspectRatio(1F)  ,

            )
        Box(modifier = Modifier.padding(15.dp).border(4.dp, color = Color.Transparent)) {
            Text(text = category.strCategoryDescription, modifier = Modifier.verticalScroll(
                rememberScrollState()).padding(8.dp), textAlign = TextAlign.Justify)
        }

    }
}