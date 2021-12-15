package com.androiddevs.mvvmnewsapp.db

import android.content.Context
import androidx.room.*
import com.androiddevs.mvvmnewsapp.model.Article

@Database(entities = arrayOf(Article::class), version = 1)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

//    abstract val articlerDAO: ArticleDao
      abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: ArticleDatabase? = null
        fun getInstance(context: Context): ArticleDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ArticleDatabase::class.java,
                        "article_data_database",
                    ).build()
                }
                return instance
            }
        }

    }
}