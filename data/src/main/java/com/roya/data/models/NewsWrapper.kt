package com.roya.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@JsonClass(generateAdapter = true)
data class NewsWrapper(

    @Json(name = "section_info")
    val results: List<News>
)
