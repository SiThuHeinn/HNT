package com.sithuhein.mm.hanacodetest.data.network

import com.sithuhein.mm.hanacodetest.data.model.ResponseOneDto
import com.sithuhein.mm.hanacodetest.data.model.ResponseTwoDto
import com.sithuhein.mm.hanacodetest.data.model.SendRequestDto
import com.sithuhein.mm.hanacodetest.domain.model.SendRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {


    @GET("posts")
    suspend fun fetchResponseOne(): List<ResponseOneDto>


    @GET("photos")
    suspend fun fetchResponseTwo(): List<ResponseTwoDto>

    @POST("posts")
    suspend fun sendRequest(
        @Body body: SendRequest
    ): Response<SendRequestDto>
}