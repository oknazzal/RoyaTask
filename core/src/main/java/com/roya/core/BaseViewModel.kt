package com.roya.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
abstract class BaseViewModel : ViewModel() {

    private var progressLiveData: MutableLiveData<Boolean>? = MutableLiveData()

    fun showProgress() {
        progressLiveData?.value = true
    }

    fun hideProgress() {
        progressLiveData?.value = false
    }

    override fun onCleared() {
        super.onCleared()
        progressLiveData = null
    }
}
