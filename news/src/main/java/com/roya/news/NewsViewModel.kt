package com.roya.news

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.paginate.Paginate
import com.roya.core.BaseViewModel
import com.roya.data.CoroutinesContextProvider
import com.roya.data.models.News
import com.roya.data.network.Resource
import com.roya.data.network.errorhandling.tryResource
import com.roya.data.repositories.news.NewsRepository
import kotlinx.coroutines.launch

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class NewsViewModel(
    private val newsRepository: NewsRepository,
    private val coroutinesContextProvider: CoroutinesContextProvider,
    private var type: String?,

    private val allNews: MutableList<News> = mutableListOf()
) : BaseViewModel(), LifecycleObserver, Paginate.Callbacks {

    private var _newsLiveData = MutableLiveData<Resource<Unit>>()
    var newsLiveData: LiveData<Resource<Unit>> = _newsLiveData

    private var loading = false
    private var loadedAllItems = false
    private var page: Int = 1

    fun getNews() {
        viewModelScope.launch(coroutinesContextProvider.io) {
            startLoadingNewsFromApi()
        }
    }

    private suspend fun startLoadingNewsFromApi() {
        loading = true
        handleShowingProgress()
        handleGettingDataOrHandleException()
        loading = false
    }

    private fun handleShowingProgress() {
        if (page == 1) {
            viewModelScope.launch(coroutinesContextProvider.main) {
                _newsLiveData.value = Resource.Loading(show = true)
            }
        }
    }

    private suspend fun handleGettingDataOrHandleException() {
        var success = false
        val resource = tryResource { newsRepository.searchByQuery(page, type) }
        if (resource is Resource.Success) {
            if (resource.data?.isEmpty() == true) {
                loadedAllItems = true
            }
            allNews.addAll(resource.data ?: listOf())
            success = true
        }
        updateUiAndHideProgress(resource, success)
    }

    private fun updateUiAndHideProgress(resource: Resource<List<News>>, success: Boolean) {
        viewModelScope.launch(coroutinesContextProvider.main) {
            _newsLiveData.value = resource.ignoreElement()
            handleHidingProgress()
            if (success) {
                page++
            }
        }
    }

    private fun handleHidingProgress() {
        if (page == 1) {
            _newsLiveData.value = Resource.Loading(show = false)
        }
    }

    fun getNewsCount(): Int {
        return allNews.size
    }

    fun getNewsBy(position: Int): News? {
        return allNews[position]
    }

    override fun onLoadMore() {
        getNews()
    }

    override fun isLoading(): Boolean = loading

    override fun hasLoadedAllItems(): Boolean = loadedAllItems
}
