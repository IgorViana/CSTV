package com.example.cstv.networking.response.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Opponent(
    @SerializedName("opponent")
    val opponent: OpponentX,
    @SerializedName("type")
    val type: String
) : Parcelable