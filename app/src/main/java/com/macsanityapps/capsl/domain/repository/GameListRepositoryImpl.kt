package com.macsanityapps.capsl.domain.repository


import com.macsanityapps.capsl.domain.model.GameListResult
import com.macsanityapps.capsl.domain.wrapper.ResponseWrapper
import com.macsanityapps.capsl.endpoint.ApiEndpoint
import com.macsanityapps.capsl.navigation.gamelist.GameListRepository
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GameListRepositoryImpl(private val apiEndpoint: ApiEndpoint) : GameListRepository {

    override fun list(): Flowable<ResponseWrapper<GameListResult>> =

        apiEndpoint.getGameList()
            .subscribeOn(Schedulers.io())


}