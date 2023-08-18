package com.example.cstv.networking.response.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    @SerializedName("score")
    val score: Int,
    @SerializedName("team_id")
    val teamId: Int
) : Parcelable