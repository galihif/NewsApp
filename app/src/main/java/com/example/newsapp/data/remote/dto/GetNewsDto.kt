package com.example.newsapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class GetNewsDto(
    @SerializedName("articles")
    val articles: List<ArticleDto>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)