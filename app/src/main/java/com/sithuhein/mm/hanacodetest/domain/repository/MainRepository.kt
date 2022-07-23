package com.sithuhein.mm.hanacodetest.domain.repository

import com.sithuhein.mm.hanacodetest.data.util.Result
import com.sithuhein.mm.hanacodetest.domain.model.ResponseOne
import com.sithuhein.mm.hanacodetest.domain.model.ResponseTwo
import com.sithuhein.mm.hanacodetest.domain.model.SendRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface MainRepository {
    fun mockedFetch(): Flow<Int>


    suspend fun fetchResponseOneData() : Flow<Result<String>>
    suspend fun fetchResponseOneDataFromCache() : Flow<Result<List<ResponseOne>>>

    suspend fun fetchResponseTwoData(): Flow<Result<List<ResponseTwo>>>
    suspend fun fetchResponseTwoDataCache(): Flow<Result<List<ResponseTwo>>>

    fun sendRequest(request: SendRequest): Flow<Result<String>>
}