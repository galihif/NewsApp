package com.example.newsapp.domain.usecase

import com.example.newsapp.domain.model.News
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    fun getListNews():Flow<Resource<List<News>>>
}