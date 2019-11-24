package com.roya.data.network

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
sealed class Resource<out T> {

    data class Success<out T>(val data: T?) : Resource<T>()

    data class Error<out T>(val error: Throwable) : Resource<T>()

    data class Loading<out T>(val show: Boolean) : Resource<T>()

    open fun ignoreElement(): Resource<Unit> {
        return when (this) {
            is Success -> Success(Unit)
            is Error -> Error(error = error)
            is Loading -> Loading(show = show)
        }
    }
}
