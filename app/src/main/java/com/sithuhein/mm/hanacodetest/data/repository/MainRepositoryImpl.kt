package com.sithuhein.mm.hanacodetest.data.repository

import android.util.Log
import com.sithuhein.mm.hanacodetest.data.local.dao.CachedDao
import com.sithuhein.mm.hanacodetest.data.network.ApiService
import com.sithuhein.mm.hanacodetest.data.util.Result
import com.sithuhein.mm.hanacodetest.domain.model.ResponseOne
import com.sithuhein.mm.hanacodetest.domain.model.ResponseTwo
import com.sithuhein.mm.hanacodetest.domain.model.SendRequest
import com.sithuhein.mm.hanacodetest.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepositoryImpl  @Inject constructor(
    private val apiService: ApiService,
    private val database: CachedDao
) : MainRepository {

    override fun mockedFetch(): Flow<Int> = flow {
        for (i in 1..10) {
            emit(i)
        }
    }

    override suspend fun fetchResponseOneData(): Flow<Result<String>> = flow {
        emit(Result.Loading())

        try {
            val response = apiService.fetchResponseOne()
            database.insert(response.map { it.toEntityModel() })
            database.fetchResponseOne().forEach {
                Log.d("HanaCodeTest","Cached -> ${it.title}")
            }
            emit(Result.Success("You have saved the data successfully!"))
        } catch (e: Exception) {
            emit(Result.Error(e.localizedMessage.orEmpty()))
        }

    }

    override suspend fun fetchResponseTwoData(): Flow<Result<List<ResponseTwo>>> = flow {
        emit(Result.Loading())

        try {
            val response = apiService.fetchResponseTwo()
            emit(Result.Success(response.map { it.toUiModel() }))

        } catch (e: Exception) {
            emit(Result.Error(e.localizedMessage.orEmpty()))
        }
    }

    override fun sendRequest(request: SendRequest): Flow<Result<String>> = flow {
        emit(Result.Loading())

        try {
            val response = apiService.sendRequest(request)

            if (response.isSuccessful) {
                emit(Result.Success("Your request is successful!"))
            } else {
                emit(Result.Error("Sorry! Your request has failed due to ${response.errorBody()}"))
            }


        } catch (e: Exception) {
                emit(Result.Error(e.localizedMessage.orEmpty()))
        }
    }

    override suspend fun fetchResponseOneDataFromCache(): Flow<Result<List<ResponseOne>>> = flow {
        emit(Result.Loading())
        try {
            val data = database.fetchResponseOne()
            emit(Result.Success(data.map { it.toUiModel() }))
        } catch (e: Exception) {

        }

    }

    override suspend fun fetchResponseTwoDataCache(): Flow<Result<List<ResponseTwo>>> = flow {
        emit(Result.Loading())

    }
}