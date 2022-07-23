package com.sithuhein.mm.hanacodetest.presentation.ui.responseone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sithuhein.mm.hanacodetest.data.util.Result.Loading
import com.sithuhein.mm.hanacodetest.data.util.Result.Success
import com.sithuhein.mm.hanacodetest.domain.model.ResponseOne
import com.sithuhein.mm.hanacodetest.domain.usecase.FetchResponseOneFromCache
import com.sithuhein.mm.hanacodetest.presentation.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResponseOneViewModel @Inject constructor(
    private val cachedUseCase: FetchResponseOneFromCache
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<ResponseOne>>>(UiState.Loading())
    val uiState = _uiState


    fun fetchFromCache() {

        viewModelScope.launch {
            cachedUseCase().onEach { result ->
                when(result) {

                    is Loading -> {
                        _uiState.value = UiState.Loading()
                    }

                    is Success -> {
                        _uiState.value = UiState.Data(result.data.orEmpty())
                    }

                    is Error -> {
                        _uiState.value = UiState.Error(result.message.orEmpty())
                    }

                }
            }.launchIn(this)
        }
    }

}