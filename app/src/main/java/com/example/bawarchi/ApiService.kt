package com.example.bawarchi

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

private val retrofit=Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/").addConverterFactory(GsonConverterFactory.create()).build()

                   val recipeService= retrofit.create(ApiService::class.java)




interface ApiService{
    @GET("categories.php")
    suspend fun getCategories():CategoryResponse
//
//    @GET("list.php?i=list")
//    suspend fun getIngredients():IngridientsResponse

    @GET("random.php")
    suspend fun getRandom():RandomResponse

    @GET("search.php")
    suspend fun getSearch(@Query("s") query: String): SearchResponse


}

