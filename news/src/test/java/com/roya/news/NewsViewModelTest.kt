package com.roya.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.roya.data.CoroutinesContextTestProviderImpl
import com.roya.data.models.News
import com.roya.data.network.Resource
import com.roya.data.repositories.news.NewsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Suppress("MagicNumber")
@ExperimentalCoroutinesApi
class NewsViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val allNews = spyk(mutableListOf<News>())
    private val newsRepository = mockk<NewsRepository>(relaxed = true)
    private val coroutinesContextProvider = CoroutinesContextTestProviderImpl()
    private val newsViewModel =
        NewsViewModel(newsRepository, coroutinesContextProvider, TYPE, allNews)

    @Before
    fun before() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `test get news success`() = runBlockingTest {
        coEvery { newsRepository.searchByQuery(1, TYPE) } returns listOf()

        var counter = 0
        val liveData = newsViewModel.newsLiveData
        liveData.observeForever { value ->
            when (counter) {
                0 -> {
                    Assert.assertEquals(value::class, Resource.Loading::class)
                    Assert.assertTrue((value as Resource.Loading<*>).show)
                }
                1 -> {
                    Assert.assertEquals(value::class, Resource.Success::class)
                }
            }
            counter++
        }
        newsViewModel.getNews()

        Assert.assertEquals(counter, 3)
        Assert.assertEquals(liveData.value!!::class, Resource.Loading::class)
        Assert.assertFalse((liveData.value as Resource.Loading<*>).show)

        verify(exactly = 1) { allNews.addAll(any()) }
        coVerify { newsRepository.searchByQuery(1, TYPE) }
    }

    private companion object {

        private const val TYPE = "nature"
    }
}
