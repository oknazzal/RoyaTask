package com.roya.data.repositories.news

import android.content.Context
import android.net.ConnectivityManager
import com.roya.data.daos.news.LocalNewsDao
import com.roya.data.daos.news.RemoteNewsDao
import com.roya.data.models.News


/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class NewsRepositoryImpl(
    private val remoteNewsDao: RemoteNewsDao,
    private val localNewsDao: LocalNewsDao,
    private val context: Context
) : NewsRepository {

    override suspend fun searchByQuery(page: Int, query: String?): List<News> {
        return if (isNetworkAvailable()) {
            val result = remoteNewsDao.searchByQuery(page).results
            localNewsDao.insert(result)
            result
        } else {
            localNewsDao.getAll()
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm?.activeNetworkInfo?.isConnected == true
    }
}
