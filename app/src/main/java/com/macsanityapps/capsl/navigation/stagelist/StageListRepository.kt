package com.macsanityapps.capsl.navigation.stagelist

import com.macsanityapps.capsl.domain.model.GameListResult
import com.macsanityapps.capsl.domain.model.StageListResult
import com.macsanityapps.capsl.domain.wrapper.ResponseWrapper
import io.reactivex.Flowable

interface StageListRepository {

    fun list(): Flowable<ResponseWrapper<StageListResult>>
}