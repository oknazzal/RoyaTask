package com.roya.core.utils.android

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
fun <T : View> Activity.bindView(@IdRes res: Int): Lazy<T?> {
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(res) }
}

fun <T : View> Fragment.bindView(@IdRes res: Int): Lazy<T?> {
    return lazy(LazyThreadSafetyMode.NONE) { view?.findViewById<T>(res) }
}

fun <T : View> View.bindView(@IdRes res: Int): Lazy<T?> {
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(res) }
}
