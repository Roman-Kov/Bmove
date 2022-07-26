package com.rojer_ko.core.result

sealed class AppResult<out T : Any> {

    object Loading : AppResult<Nothing>()
    object Empty : AppResult<Nothing>()
    data class Failure(val throwable: Throwable) : AppResult<Nothing>()
    data class Success<out T : Any>(val data: T) : AppResult<T>()
}

inline fun <T : Any> AppResult<T>.onSuccess(block: (T) -> Unit): AppResult<T> {
    if (this is AppResult.Success) block(this.data)
    return this
}

inline fun <T : Any> AppResult<T>.onFailure(block: (Throwable) -> Unit): AppResult<T> {
    if (this is AppResult.Failure) block(this.throwable)
    return this
}

inline fun <T : Any> AppResult<T>.onLoading(block: () -> Unit): AppResult<T> {
    if (this is AppResult.Loading) block()
    return this
}

inline fun <T : Any> AppResult<T>.onEmpty(block: () -> Unit): AppResult<T> {
    if (this is AppResult.Empty) block()
    return this
}