package com.macsanityapps.capsl.di.component

import com.macsanityapps.base.di.module.NetworkModule
import com.macsanityapps.capsl.CapslApp
import com.macsanityapps.capsl.di.module.ApiModule
import com.macsanityapps.capsl.di.module.AppModule
import com.macsanityapps.capsl.di.module.DataModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ApiModule::class,
        DataModule::class,
        AppModule::class

    ]
)
interface AppComponent : AndroidInjector<CapslApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<CapslApp>()

}