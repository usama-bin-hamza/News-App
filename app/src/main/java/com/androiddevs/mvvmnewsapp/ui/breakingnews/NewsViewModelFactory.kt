package com.androiddevs.mvvmnewsapp.ui.breakingnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.mvvmnewsapp.repositories.NewsRepository

class NewsViewModelFactory(
    private val repository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BreakingNewsViewModel::class.java)) {
            return BreakingNewsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}