package com.macsanityapps.capsl

import com.macsanityapps.capsl.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class CapslApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)


    override fun onCreate() {
        super.onCreate()
    }
}