package com.androiddevs.mvvmnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase.Companion.getInstance
import com.androiddevs.mvvmnewsapp.repositories.NewsRepository
import com.androiddevs.mvvmnewsapp.ui.breakingnews.BreakingNewsViewModel
import com.androiddevs.mvvmnewsapp.ui.breakingnews.NewsViewModelFactory
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: BreakingNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val dao = ArticleDatabase.getInstance(this)
        val newsRepository = NewsRepository(dao)
        val viewModelProviderFactory = NewsViewModelFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(BreakingNewsViewModel::class.java)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }
}
