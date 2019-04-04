package com.macsanityapps.capsl.navigation.gamelist

import com.macsanityapps.capsl.domain.model.GameListResult
import com.macsanityapps.capsl.domain.wrapper.ResponseWrapper
import io.reactivex.Flowable

interface GameListRepository {

    fun list(): Flowable<ResponseWrapper<GameListResult>>

}