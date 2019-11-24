package com.roya.di

import com.roya.main.MainActivity
import com.roya.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}
