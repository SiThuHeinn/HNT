package com.sithuhein.mm.hanacodetest.data.model

import com.sithuhein.mm.hanacodetest.data.local.entity.ResponseOneEntity
import com.sithuhein.mm.hanacodetest.domain.model.ResponseOne

data class ResponseOneDto(
    val userId: String,
    val id: String,
    val title: String,
    val body: String
) {


    fun uiModel() : ResponseOne {
        return ResponseOne(
            userId = userId,
            id = id,
            title = title,
            body = body
        )
    }

    fun toEntityModel(): ResponseOneEntity {
        return ResponseOneEntity(
            id = id,
            userId = userId,
            title = title,
            body = body
        )
    }
}