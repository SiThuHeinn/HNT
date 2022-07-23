package com.sithuhein.mm.hanacodetest.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sithuhein.mm.hanacodetest.domain.model.ResponseOne

@Entity(tableName = "response_one_table")
data class ResponseOneEntity(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "userId")
    val userId: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "body")
    val body: String
) {

    fun toUiModel(): ResponseOne {
        return ResponseOne(
            id = id,
            userId =  userId,
            title = title,
            body = body
        )
    }
}