package com.roya

import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import com.roya.data.binding.BindingAdapters
import com.roya.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class MyApplication : DaggerApplication() {

    @Inject
    lateinit var bindingAdapters: BindingAdapters

    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(object : DataBindingComponent {

            override fun getBindingAdapters(): BindingAdapters {
                return this@MyApplication.bindingAdapters
            }
        })
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
            .apply {
                inject(this@MyApplication)
            }
    }
}
