package com.roya.data.daos.news

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.roya.data.models.News

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Dao
interface LocalNewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: List<News>)

    @Query("SELECT * FROM news")
    suspend fun getAll(): List<News>
}
