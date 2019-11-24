package com.roya.data.network.errorhandling

import com.roya.data.network.Resource
import com.squareup.moshi.JsonEncodingException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
private const val HTTP_CODE_CLIENT_START = 400
private const val HTTP_CODE_CLIENT_END = 499

private const val HTTP_CODE_SERVER_START = 500
private const val HTTP_CODE_SERVER_END = 599

inline fun <T> tryResource(func: () -> T): Resource<T> {
    return try {
        Resource.Success(data = func())
    } catch (e: Exception) {
        Resource.Error(error = getRequestException(e))
    }
}


fun getRequestException(cause: Throwable): NetworkException {
    return when (cause) {
        is HttpException -> {
            handleHttpException(cause)
        }
        is SocketTimeoutException -> {
            NetworkException.Timeout(cause.message, cause)
        }
        is JsonEncodingException -> {
            NetworkException.Data(cause.message, cause)
        }
        is IOException -> {
            NetworkException.Network(cause.message, cause)
        }
        else -> {
            NetworkException.Unexpected(cause.message, cause)
        }
    }
}

fun handleHttpException(cause: HttpException): NetworkException {
    return when (cause.code()) {
        in HTTP_CODE_CLIENT_START..HTTP_CODE_CLIENT_END -> {
            NetworkException.Client(cause.message, cause)
        }
        in HTTP_CODE_SERVER_START..HTTP_CODE_SERVER_END -> {
            NetworkException.Server(cause.message, cause)
        }
        else -> {
            NetworkException.Unexpected(cause.message, cause)
        }
    }
}
