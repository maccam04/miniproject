package com.macsanityapps.capsl.domain.wrapper

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.macsanityapps.capsl.domain.model.GameListResult
import kotlinx.android.parcel.RawValue

data class ResponseWrapper<out T>(

    @SerializedName("count")
    @Expose
    val count: Int? = null,

    @SerializedName("next")
    @Expose
    val next: Int? = null,

    @SerializedName("previous")
    @Expose
    val previous: Int? = null,

    @SerializedName("results")
    @Expose
    val results: List<@RawValue T>? = null
)