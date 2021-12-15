package com.androiddevs.mvvmnewsapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androiddevs.mvvmnewsapp.utils.Constants.Companion.TABLE_NAME
import java.io.Serializable

@Entity(tableName = TABLE_NAME)
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    val author: String,

//    @ColumnInfo(name = "content")
    val content: String,

//    @ColumnInfo(name = "description")
    val description: String,

//    @ColumnInfo(name = "publishedAt")
    val publishedAt: String,

//    @ColumnInfo(name = "source")
    val source: Source,  // here we have to tell that it's our source class because room handle String int type and for this we have to create Converts

//    @ColumnInfo(name = "title")
    val title: String,

//    @ColumnInfo(name = "url")
    val url: String,

//    @ColumnInfo(name = "urlToImage")
    val urlToImage: String
) : Serializable