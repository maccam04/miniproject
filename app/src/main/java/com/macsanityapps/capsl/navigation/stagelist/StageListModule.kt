package com.macsanityapps.capsl.navigation.stagelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.macsanityapps.base.di.key.ViewModelKey
import com.macsanityapps.capsl.navigation.gamelist.GameListViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module(includes = [
    StageListModule.ProvideViewModel::class

])
abstract class StageListModule {

    @ContributesAndroidInjector(
        modules = [
            InjectViewModel::class
        ]
    )
    abstract fun bind(): StageListFragment

    @Module
    class ProvideViewModel {

        @Provides
        @IntoMap
        @ViewModelKey(StageListViewModel::class)
        fun provideViewModel(stageListRepository: StageListRepository): ViewModel =
            StageListViewModel(stageListRepository)
    }


    @Module
    class InjectViewModel {

        @Provides
        fun provideStageListViewModel(
            factory: ViewModelProvider.Factory,
            target: StageListFragment
        ): StageListViewModel =
            ViewModelProviders.of(target, factory).get(StageListViewModel::class.java)

    }

}