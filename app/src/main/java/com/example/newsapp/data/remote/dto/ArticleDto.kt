package com.example.newsapp.data.remote.dto


import com.example.newsapp.domain.model.News
import com.google.gson.annotations.SerializedName

data class ArticleDto(
    @SerializedName("author")
    val author: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String
)

fun ArticleDto.toNews():News{
    return News(
        title = title,
        desc = description,
        image = urlToImage
    )
}