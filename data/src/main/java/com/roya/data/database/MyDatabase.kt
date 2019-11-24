package com.roya.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roya.data.daos.news.LocalNewsDao
import com.roya.data.models.News

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Database(
    entities = [News::class],
    version = 1
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun localNewsDao(): LocalNewsDao
}
