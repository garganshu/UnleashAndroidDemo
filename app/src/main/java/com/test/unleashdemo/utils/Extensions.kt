package com.test.unleashdemo.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T, R> Response<T>.responseMap(map: suspend (T) -> R): Response<R> {
    return when (this) {
        is Response.Success -> Response.Success(map(this.data))
        is Response.Failure -> Response.Failure(error)
    }
}

suspend fun <T>getUnleashResponse(data: suspend () -> T): Response<T> {
    return try {
        Response.Success(data())
    } catch (e: Exception) {
        Log.d("Exception: ", e.toString())
        val error = when (e) {
            is UnknownHostException, is SocketTimeoutException -> "No Internet Connection"
            is HttpException -> e.message.toString()
            else -> "Generic Error"
        }
        Response.Failure(error)
    }
}

fun Context.browseUrl(url: String?) {
    if(!url.isNullOrEmpty()) {
        val browseIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browseIntent, null)
    }
}