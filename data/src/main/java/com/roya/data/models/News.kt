package com.roya.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Entity(tableName = "news")
@JsonClass(generateAdapter = true)
class News(

    @PrimaryKey
    @Json(name = "news_id")
    var newsId: Int = 0,

    @Json(name = "news_title")
    var newsTitle: String? = null,

    @Json(name = "imageLink")
    var imageLink: String? = null,

    @Json(name = "section_name")
    var sectionName: String? = null
)
