package com.example.cstv.networking.response.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Game(
    @SerializedName("beginAt")
    val beginAt: String,
    @SerializedName("complete")
    val complete: Boolean,
    @SerializedName("detailed_stats")
    val detailedStats: Boolean,
    @SerializedName("end_at")
    val endAt: String,
    @SerializedName("finished")
    val finished: Boolean,
    @SerializedName("forfeit")
    val forfeit: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("length")
    val length: @RawValue Any?,
    @SerializedName("match_id")
    val matchId: Long,
    @SerializedName("position")
    val position: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("winner")
    val winner: Winner,
    @SerializedName("winner_type")
    val winnerType: String
):Parcelable