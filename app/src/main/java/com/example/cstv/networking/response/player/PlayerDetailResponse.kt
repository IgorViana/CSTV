package com.example.cstv.networking.response.player

import com.google.gson.annotations.SerializedName

data class PlayerDetailResponse(
    @SerializedName("opponent_type")
    val opponentType: String,
    @SerializedName("opponents")
    val opponents: List<Opponent>
)