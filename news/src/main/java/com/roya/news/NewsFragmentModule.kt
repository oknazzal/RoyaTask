package com.roya.news

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.roya.data.CoroutinesContextProvider
import com.roya.data.repositories.news.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Module
abstract class NewsFragmentModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideViewModel(
            fragment: Fragment,
            factory: NewsViewModelFactory
        ): NewsViewModel {
            return ViewModelProvider(fragment, factory)[NewsViewModel::class.java]
        }

        @Provides
        @JvmStatic
        fun provideNewsViewModelFactory(
            fragment: Fragment,
            newsRepository: NewsRepository,
            coroutinesContextProvider: CoroutinesContextProvider
        ): NewsViewModelFactory {
            val type = fragment.arguments?.getString("type")
            return NewsViewModelFactory(newsRepository, coroutinesContextProvider, type)
        }
    }

    @Binds
    abstract fun bindActivity(activity: NewsFragment): Fragment
}
