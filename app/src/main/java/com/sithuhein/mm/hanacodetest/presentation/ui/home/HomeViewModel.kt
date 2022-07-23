package com.sithuhein.mm.hanacodetest.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sithuhein.mm.hanacodetest.data.util.Result
import com.sithuhein.mm.hanacodetest.domain.usecase.FetchResponseOneUseCase
import com.sithuhein.mm.hanacodetest.presentation.util.UiState.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
     private val fetchResponseOneUseCase: FetchResponseOneUseCase
): ViewModel() {

    private val _state = MutableStateFlow("")

    val state = _state

    fun fetch() {
        viewModelScope.launch {

            fetchResponseOneUseCase().onEach { result ->
                when(result) {
                    is Result.Loading -> {}

                    is Result.Success -> {
                        _state.value = "You have downloaded successfully!"
                    }

                    is Result.Error -> {
                        _state.value = result.message.orEmpty()
                    }
                }
            }.launchIn(this)
        }
    }
}