package com.sithuhein.mm.hanacodetest.presentation.util

sealed class UiState<T>(val data:T? = null, val message: String? = null) {

    class Noting<T>: UiState<T>()
    class Loading<T>: UiState<T>()
    class Data<T>(val list: T): UiState<T>(data = list)
    class Error<T>(message: String): UiState<T>(message = message)
}