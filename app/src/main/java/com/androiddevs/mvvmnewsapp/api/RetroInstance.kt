package com.androiddevs.mvvmnewsapp.api

import com.androiddevs.mvvmnewsapp.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class RetroInstance {

    companion object {
        val clientSetup = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES) // write timeout
            .readTimeout(1, TimeUnit.MINUTES) // read timeout
            .build()

        fun getRetroInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(clientSetup)
                .build()
        }

        val api by lazy {
            getRetroInstance().create(NewsApi::class.java)
        }
    }
}