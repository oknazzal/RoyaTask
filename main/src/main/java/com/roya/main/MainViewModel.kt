package com.roya.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.roya.core.BaseViewModel

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class MainViewModel : BaseViewModel(), LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        // No impl
    }
}
