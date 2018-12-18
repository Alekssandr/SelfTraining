package com.intive.selftraining.selftraining.di

import android.content.Context
import androidx.annotation.NonNull
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.network.ErrorHandler
import com.intive.selftraining.selftraining.network.KeyInterceptor
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.utils.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(KeyInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideNetworkInterface(@NonNull retrofit: Retrofit): NetworkInterface {
        return retrofit.create(NetworkInterface::class.java)
    }

    @Provides
    fun provideCustomScheduler(): CustomScheduler {
        return CustomScheduler()
    }

    @Provides
    fun provideErrorHandler(context: Context): ErrorHandler {
        return ErrorHandler(context)
    }
}