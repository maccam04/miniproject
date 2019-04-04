package com.macsanityapps.capsl.domain.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameListResult(
    @SerializedName("gameId")
    @Expose
    val id: Int? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("is_active")
    @Expose
    val isActive: Boolean? = null
) : Parcelable

@Parcelize
data class StageListResult(
    @SerializedName("gameId")
    @Expose
    val id: Int? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("is_active")
    @Expose
    val isActive: Boolean? = null

) : Parcelable


