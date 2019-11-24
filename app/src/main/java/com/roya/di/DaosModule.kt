package com.roya.di

import com.roya.data.daos.news.LocalNewsDao
import com.roya.data.daos.news.RemoteNewsDao
import com.roya.data.database.MyDatabase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Module
object DaosModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideLocalNewsDao(database: MyDatabase): LocalNewsDao {
        return database.localNewsDao()
    }

    @Singleton
    @Provides
    @JvmStatic
    fun provideRemoteNewsDao(retrofit: Retrofit): RemoteNewsDao {
        return retrofit.create(RemoteNewsDao::class.java)
    }
}
