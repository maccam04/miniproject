package com.macsanityapps.capsl.domain.repository

import com.macsanityapps.capsl.domain.model.StageListResult
import com.macsanityapps.capsl.domain.wrapper.ResponseWrapper
import com.macsanityapps.capsl.endpoint.ApiEndpoint
import com.macsanityapps.capsl.navigation.stagelist.StageListRepository
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class StageListRepositoryImpl(private val apiEndpoint: ApiEndpoint) : StageListRepository {

    override fun list(): Flowable<ResponseWrapper<StageListResult>> =
        apiEndpoint.getStageList().observeOn(Schedulers.io())

}