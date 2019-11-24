package com.roya.data

import kotlin.coroutines.CoroutineContext

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
interface CoroutinesContextProvider {

    val main: CoroutineContext

    val io: CoroutineContext
}
