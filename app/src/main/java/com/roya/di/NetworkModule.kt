package com.roya.di

import com.roya.data.BuildConfig
import com.roya.data.moshi.ColorAdapter
import com.roya.data.network.ClientIdInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import tech.linjiang.pandora.Pandora
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
@Module
object NetworkModule {

    private const val TIMEOUT_MINUTES = 1L

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttp(clientIdInterceptor: ClientIdInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(Pandora.get().interceptor)
            .readTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
            .writeTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
            .connectTimeout(TIMEOUT_MINUTES, TimeUnit.MINUTES)
            .addInterceptor(clientIdInterceptor)
            .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideClientIdInterceptor(): ClientIdInterceptor {
        return ClientIdInterceptor()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideConverterFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(ColorAdapter())
            .build()
    }
}
