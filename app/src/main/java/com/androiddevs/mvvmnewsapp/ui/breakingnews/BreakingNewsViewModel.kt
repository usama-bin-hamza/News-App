package com.androiddevs.mvvmnewsapp.ui.breakingnews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.mvvmnewsapp.model.Article
import com.androiddevs.mvvmnewsapp.model.NewsResponse
import com.androiddevs.mvvmnewsapp.repositories.NewsRepository
import com.androiddevs.mvvmnewsapp.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class BreakingNewsViewModel(
    val newsRepository : NewsRepository
) : ViewModel() {

    val breakingnews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakinNewsPage = 1

    val searchnews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1

    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        breakingnews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode, breakinNewsPage)
        breakingnews.postValue(handleBreakingNewsResponse(response))
    }

    fun getSearchNews(countryCode: String) = viewModelScope.launch {
        searchnews.postValue(Resource.Loading())
        val response = newsRepository.serachForNews(countryCode, searchNewsPage)
        searchnews.postValue(handleSearchNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleSearchNewsResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun savedArticle(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }

    fun getSavedArticle() = newsRepository.getSavedNews()

    fun deleteArticle(article: Article) = viewModelScope.launch {
        newsRepository.deleteArticle(article)
    }

}