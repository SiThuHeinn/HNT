package com.sithuhein.mm.hanacodetest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sithuhein.mm.hanacodetest.data.local.dao.CachedDao
import com.sithuhein.mm.hanacodetest.data.local.entity.ResponseOneEntity

@Database(
    entities = arrayOf(ResponseOneEntity::class),
    version = 1,
    exportSchema = false
)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun cachedDao(): CachedDao
}