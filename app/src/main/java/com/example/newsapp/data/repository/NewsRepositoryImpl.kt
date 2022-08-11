package com.example.newsapp.data.repository

import android.util.Log
import com.example.newsapp.data.remote.RemoteDataSource
import com.example.newsapp.data.remote.dto.toNews
import com.example.newsapp.domain.model.News
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remote:RemoteDataSource
):NewsRepository {

    override fun getListNews(): Flow<Resource<List<News>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val listNews = remote.getNews().articles.map { it.toNews() }
                emit(Resource.Success(listNews))
                Log.d("OKHTTP GALIH", listNews.size.toString())
            }catch (e: HttpException){
                emit(Resource.Error(e.localizedMessage ?: "Unexpected error occured"))
                Log.d("OKHTTP GALIH", e.message())
            }catch (e: IOException){
                emit(Resource.Error(e.localizedMessage ?: "Unexpected error occured"))
                Log.d("OKHTTP GALIH", e.message.toString())
            }
        }
    }

}