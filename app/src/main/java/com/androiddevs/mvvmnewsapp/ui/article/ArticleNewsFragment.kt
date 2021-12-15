package com.androiddevs.mvvmnewsapp.ui.article

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.ui.NewsActivity
import com.androiddevs.mvvmnewsapp.ui.breakingnews.BreakingNewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleNewsFragment : Fragment() {

    private lateinit var viewModel: BreakingNewsViewModel
    val agr : ArticleNewsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        val article = agr.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            viewModel.savedArticle(article)
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_LONG).show()
        }

    }

}