package com.gunish.retrofitexample

import retrofit2.http.GET
import com.gunish.retrofitexample.models.DogImageModel
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiClient {
    @GET("/api/breeds/image/random")
    suspend fun getRandomDogImage(): Response<DogImageModel>
}
object ApiAdapter{
    val apiClient:ApiClient=Retrofit.Builder().baseUrl("https://dog.ceo").client(OkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient::class.java)

}