package com.roya.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.coroutines.CoroutineContext

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@UseExperimental(ExperimentalCoroutinesApi::class)
class CoroutinesContextTestProviderImpl : CoroutinesContextProvider {

    override val main: CoroutineContext
        get() = Dispatchers.Unconfined

    override val io: CoroutineContext
        get() = Dispatchers.Unconfined
}
