package com.example.newsapp.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.newsapp.R
import com.example.newsapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel:HomeViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel.news.observe(this){
            when(it){
                is Resource.Success -> {
                    Log.d("GALIH", it.data?.size.toString())
                    Toast.makeText(this, it.data?.size.toString(), Toast.LENGTH_SHORT).show()
                }
                is Resource.Error -> Log.d("GALIH", it.message.toString())
                is Resource.Loading -> Log.d("GALIH", "loading")
            }
        }
    }
}