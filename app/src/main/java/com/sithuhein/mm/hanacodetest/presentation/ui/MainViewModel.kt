package com.sithuhein.mm.hanacodetest.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sithuhein.mm.hanacodetest.data.util.Result.Error
import com.sithuhein.mm.hanacodetest.data.util.Result.Loading
import com.sithuhein.mm.hanacodetest.data.util.Result.Success
import com.sithuhein.mm.hanacodetest.domain.model.SendRequest
import com.sithuhein.mm.hanacodetest.domain.usecase.FetchResponseOneUseCase
import com.sithuhein.mm.hanacodetest.domain.usecase.FetchResponseTwoUseCase
import com.sithuhein.mm.hanacodetest.domain.usecase.MainUseCase
import com.sithuhein.mm.hanacodetest.domain.usecase.SendRequestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.onEach

import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchResponseOneUseCase: FetchResponseOneUseCase,
    private val fetchResponseTwoUseCase: FetchResponseTwoUseCase,
    private val sendRequestUseCase: SendRequestUseCase
) : ViewModel() {


    init {
        Log.d("HanaCodeTest", "viewModel initiated.")
        mockFetch()

    }

    fun sendRequest() {
        val request = SendRequest(userId = "1", title = "This is title", body = "This is body")
        viewModelScope.launch {
            sendRequestUseCase(request).onEach { result ->
                when(result) {
                    is Loading -> {
                        Log.d("HanaCodeTest", "Loading ...")
                    }

                    is Success -> {
                        Log.d("HanaCodeTest", "Data -> ${result.data}")
                    }

                    is Error -> {
                        Log.d("HanaCodeTest", "Failed -> ${result.message}")
                    }
                }
            }.launchIn(this)
        }
    }


    fun mockFetch() {
        viewModelScope.launch {
           fetchResponseOneUseCase().onEach { result ->
                when(result) {
                    is Loading -> {
                        Log.d("HanaCodeTest", "Loading ...")
                    }

                    is Success -> {
                        Log.d("HanaCodeTest", result.data.orEmpty())
                    }

                    is Error -> {
                        Log.d("HanaCodeTest", result.message.orEmpty())
                    }
                }
           }.launchIn(this)
        }
    }
}