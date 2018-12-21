package com.intive.selftraining.selftraining.di

import com.intive.selftraining.selftraining.MainApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class])
interface AppComponent: AndroidInjector<DaggerApplication> {
    fun inject(app: MainApplication)
}