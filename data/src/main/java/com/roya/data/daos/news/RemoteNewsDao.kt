package com.roya.data.daos.news

import com.roya.data.models.NewsWrapper
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
interface RemoteNewsDao {

    @GET("section/get/1/info/{page}")
    suspend fun searchByQuery(@Query("page") page: Int): NewsWrapper
}
