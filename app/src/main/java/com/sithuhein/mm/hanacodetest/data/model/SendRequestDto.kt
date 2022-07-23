package com.sithuhein.mm.hanacodetest.data.model

import com.sithuhein.mm.hanacodetest.domain.model.SendRequest

data class SendRequestDto(
    val userId: String,
    val title: String,
    val body: String
) {

    fun toUiModel(): SendRequest {
        return SendRequest(
            userId = userId,
            title = title,
            body = body
        )
    }
}