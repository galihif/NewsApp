package com.example.newsapp.data.remote

import com.example.newsapp.data.remote.network.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api:ApiService
) {
    suspend fun getNews() = api.getNews()
}