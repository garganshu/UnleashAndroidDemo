package com.test.unleashdemo.utils

sealed class Response<T> {
    data class Success<T>(val data: T): Response<T>()
    data class Failure<T>(val error: String): Response<T>()
}