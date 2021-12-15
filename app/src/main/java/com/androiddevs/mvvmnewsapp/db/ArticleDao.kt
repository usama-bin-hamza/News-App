package com.androiddevs.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.model.Article
import com.androiddevs.mvvmnewsapp.utils.Constants.Companion.TABLE_NAME

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article) //: Long

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deletArticle(article: Article) //: Int
}