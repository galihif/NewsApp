package com.example.newsapp.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityHomeBinding
import com.example.newsapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel:HomeViewModel by viewModels()

    private lateinit var binding: ActivityHomeBinding

    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()

        viewModel.news.observe(this){
            when(it){
                is Resource.Success -> {
                    showLoading(false)
                    adapter.submitList(it.data)
                }
                is Resource.Error -> {
                    showLoading(false)
                    Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    showLoading(true)
                }
            }
        }
    }
    
    private fun showLoading(isLoading:Boolean) {
        binding.loading.visibility = if(isLoading) View.VISIBLE else View.GONE
    }

    private fun setupAdapter() {
        adapter = NewsAdapter()
        binding.rvNews.adapter = adapter
    }
}