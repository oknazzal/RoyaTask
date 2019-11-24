package com.roya.data

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class CoroutinesContextProviderImpl : CoroutinesContextProvider {

    override val main: CoroutineContext
        get() = Dispatchers.Main

    override val io: CoroutineContext
        get() = Dispatchers.IO
}
