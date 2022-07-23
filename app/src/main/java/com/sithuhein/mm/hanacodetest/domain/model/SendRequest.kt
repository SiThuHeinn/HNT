package com.sithuhein.mm.hanacodetest.domain.model

import com.sithuhein.mm.hanacodetest.data.model.SendRequestDto

data class SendRequest(
    val userId: String,
    val title: String,
    val body: String
) {

}