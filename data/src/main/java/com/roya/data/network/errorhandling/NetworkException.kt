package com.roya.data.network.errorhandling

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
sealed class NetworkException(message: String?, cause: Throwable) : RuntimeException(message, cause) {

    class Client(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Server(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Timeout(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Data(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Network(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Unexpected(message: String?, cause: Throwable) : NetworkException(message, cause)
}
