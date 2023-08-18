package com.example.cstv.networking.response.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tournament(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("detailed_stats")
    val detailedStats: Boolean,
    @SerializedName("end_at")
    val endAt: String,
    @SerializedName("has_bracket")
    val hasBracket: Boolean,
    @SerializedName("language")
    val id: Int,
    @SerializedName("league_id")
    val leagueId: Int,
    @SerializedName("live_supported")
    val liveSupported: Boolean,
    @SerializedName("modified_at")
    val modifiedAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("prizepool")
    val prizepool: String,
    @SerializedName("serie_id")
    val serieId: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("tier")
    val tier: String,
    @SerializedName("winner_id")
    val winnerId: Int,
    @SerializedName("winner_type")
    val winnerType: String
) : Parcelable