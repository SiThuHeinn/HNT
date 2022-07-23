package com.sithuhein.mm.hanacodetest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sithuhein.mm.hanacodetest.data.local.entity.ResponseOneEntity
import com.sithuhein.mm.hanacodetest.domain.model.ResponseOne
import javax.inject.Inject

@Dao
interface CachedDao {

    @Query("SELECT * from response_one_table")
    suspend fun fetchResponseOne(): List<ResponseOneEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<ResponseOneEntity>)


}