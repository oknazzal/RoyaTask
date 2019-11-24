package com.roya.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roya.data.CoroutinesContextProvider
import com.roya.data.repositories.news.NewsRepository

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class NewsViewModelFactory(
    private val newsRepository: NewsRepository,
    private val coroutinesContextProvider: CoroutinesContextProvider,
    private val type: String?
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository, coroutinesContextProvider, type) as T
    }
}
