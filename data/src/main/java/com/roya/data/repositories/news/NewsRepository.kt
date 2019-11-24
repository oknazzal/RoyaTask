package com.roya.data.repositories.news

import com.roya.data.models.News

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
interface NewsRepository {

    suspend fun searchByQuery(page: Int, query: String?): List<News>
}
