package com.androiddevs.mvvmnewsapp.repositories

import com.androiddevs.mvvmnewsapp.api.RetroInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.model.Article

class NewsRepository(
   val db: ArticleDatabase
) {
    suspend fun getBreakingNews(country: String, pageNumber: Int) =
        RetroInstance.api.getBreakingNews(country, pageNumber)

    suspend fun serachForNews(country: String, pageNumber: Int) =
        RetroInstance.api.serachForNews(country, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deletArticle(article)
}