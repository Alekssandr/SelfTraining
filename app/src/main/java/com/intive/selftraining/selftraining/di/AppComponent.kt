package com.intive.selftraining.selftraining.di

import com.intive.selftraining.selftraining.MainApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    ListMoviesModule::class,
    MovieDetailsModule::class])
interface AppComponent {
    fun inject(app: MainApplication)
//    fun injectOkHttpClient(okHttpClient: OkHttpClient)
//    fun injectRetrofit(retrofit: Retrofit)
//    fun injectNetworkInterface(networkInterface: NetworkInterface)
}