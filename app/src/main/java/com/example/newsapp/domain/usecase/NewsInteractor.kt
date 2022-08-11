package com.example.newsapp.domain.usecase

import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val repository: NewsRepository
):NewsUseCase {
    override fun getListNews(): Flow<Resource<List<News>>> = repository.getListNews()
}