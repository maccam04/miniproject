package com.macsanityapps.capsl.di.module

import com.macsanityapps.capsl.domain.repository.GameListRepositoryImpl
import com.macsanityapps.capsl.domain.repository.StageListRepositoryImpl
import com.macsanityapps.capsl.endpoint.ApiEndpoint
import com.macsanityapps.capsl.navigation.gamelist.GameListRepository
import com.macsanityapps.capsl.navigation.stagelist.StageListRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideGameListRepository(apiEndpoint: ApiEndpoint): GameListRepository =
        GameListRepositoryImpl(apiEndpoint)

    @Provides
    fun provideStageListRepository(apiEndpoint: ApiEndpoint) : StageListRepository =
            StageListRepositoryImpl(apiEndpoint)

}