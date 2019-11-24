package com.roya.di

import com.roya.news.NewsFragment
import com.roya.news.NewsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [NewsFragmentModule::class])
    abstract fun bindNewsFragment(): NewsFragment
}
