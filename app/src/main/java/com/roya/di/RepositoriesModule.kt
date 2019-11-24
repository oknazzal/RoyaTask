package com.roya.di

import android.content.Context
import com.roya.data.daos.news.LocalNewsDao
import com.roya.data.daos.news.RemoteNewsDao
import com.roya.data.repositories.news.NewsRepository
import com.roya.data.repositories.news.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Module
object RepositoriesModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideNewsRepository(
        remoteNewsDao: RemoteNewsDao,
        localNewsDao: LocalNewsDao,
        context: Context
    ): NewsRepository {
        return NewsRepositoryImpl(remoteNewsDao, localNewsDao, context)
    }
}
