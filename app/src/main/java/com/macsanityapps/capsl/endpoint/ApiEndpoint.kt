package com.macsanityapps.capsl.endpoint


import com.macsanityapps.capsl.domain.model.GameListResult
import com.macsanityapps.capsl.domain.model.StageListResult
import com.macsanityapps.capsl.domain.wrapper.ResponseWrapper
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiEndpoint {

    companion object {
        val ENDPOINT = "http://13.231.86.234:5000/api/"
    }

    @GET("games")
    fun getGameList(): Flowable<ResponseWrapper<GameListResult>>

    @GET("stages")
    fun getStageList(): Flowable<ResponseWrapper<StageListResult>>


}