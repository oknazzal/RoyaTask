package com.roya.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context
}
