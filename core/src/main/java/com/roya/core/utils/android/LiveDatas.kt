package com.roya.core.utils.android

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
inline fun <T> LiveData<T>.observe(owner: LifecycleOwner, crossinline callback: (T) -> Unit) {
    observe(owner, Observer { callback(it) })
}
