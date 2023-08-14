package com.example.cstv.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

sealed class Result<out T> {
    data class Success<out T>(val response: T) : Result<T>()
    data class Error(val error: String) : Result<Nothing>()

    data class Loading(val loading: Boolean) : Result<Nothing>()

    fun isSuccess(): Boolean = this is Success
    fun isFailure(): Boolean = this is Error
    fun isLoading(): Boolean = this is Loading

    fun <T> Flow<Result<T>>.onSuccess(action: suspend (T) -> Unit): Flow<Result<T>> {
        return transform { value ->
            if (value is Success) {
                action(value.response)
            }
            return@transform emit(value)
        }
    }

    inline fun onSuccess(action: (T) -> Unit): Result<T> {
        if (this is Success) {
            action(response)
        }
        return this
    }

    inline fun onFailure(action: (String) -> Unit): Result<T> {
        if (this is Error) {
            action(error)
        }
        return this
    }

    inline fun onLoading(action: (Boolean) -> Unit): Result<T> {
        if (this is Loading) {
            action(loading)
        }
        return this
    }
}
