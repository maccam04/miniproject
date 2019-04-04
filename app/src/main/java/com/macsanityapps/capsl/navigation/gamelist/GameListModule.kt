package com.macsanityapps.capsl.navigation.gamelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.macsanityapps.base.di.key.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module(
    includes = [
        GameListModule.ProvideViewModel::class
    ]
)
abstract class GameListModule {

    @ContributesAndroidInjector(modules = [
        InjectViewModel::class
    ])
    abstract fun bind(): GameListFragment

    @Module
    class ProvideViewModel {

        @Provides
        @IntoMap
        @ViewModelKey(GameListViewModel::class)
        fun provideViewModel(gameListRepository: GameListRepository): ViewModel =
            GameListViewModel(gameListRepository)
    }


    @Module
    class InjectViewModel {

        @Provides
        fun provideGameListViewModel(
            factory: ViewModelProvider.Factory,
            target: GameListFragment
        ): GameListViewModel =
            ViewModelProviders.of(target, factory).get(GameListViewModel::class.java)

    }
}