package com.macsanityapps.capsl.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.macsanityapps.base.core.BaseViewModelFactory
import com.macsanityapps.capsl.navigation.gamelist.GameListModule
import com.macsanityapps.capsl.navigation.stagelist.StageListModule
import dagger.Module
import dagger.Provides
import javax.inject.Provider


@Module(
    includes = [
        GameListModule::class,
        StageListModule::class
    ]
)
class AppModule {

    @Provides
    fun provideViewModelFactory(
        providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): ViewModelProvider.Factory =
        BaseViewModelFactory(providers)

}