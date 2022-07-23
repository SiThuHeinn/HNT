package com.sithuhein.mm.hanacodetest.data.model

import com.sithuhein.mm.hanacodetest.domain.model.ResponseTwo

data class ResponseTwoDto(
    val albumId: String,
    val id: String,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) {

    fun toUiModel() : ResponseTwo {
        return ResponseTwo(
            albumId = albumId,
            id = id,
            title = title,
            url = url,
            thumbnailUrl = thumbnailUrl
        )
    }
}