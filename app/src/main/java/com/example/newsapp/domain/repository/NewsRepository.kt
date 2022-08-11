package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.News
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getListNews():Flow<Resource<List<News>>>
}