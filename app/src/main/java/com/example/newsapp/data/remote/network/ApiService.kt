package com.example.newsapp.data.remote.network

import com.example.newsapp.data.remote.dto.GetNewsDto
import com.example.newsapp.utils.Constant
import retrofit2.http.GET

interface ApiService {

    @GET("top-headlines?country=us&apiKey=${Constant.API_KEY}")
    suspend fun getNews():GetNewsDto
}