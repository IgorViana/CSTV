package com.example.cstv.networking.response.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Winner(
    @SerializedName("id")
    val id: Int,
    @SerializedName("type")
    val type: String
):Parcelable