package com.test.unleashdemo.utils

sealed class ViewState<T> {
    data class Loading<T>(val setLoading: Boolean): ViewState<T>()
    data class Success<T>(val data: T): ViewState<T>()
    data class Error<T>(val error: String): ViewState<T>()
}