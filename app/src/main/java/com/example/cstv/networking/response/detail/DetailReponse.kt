package com.example.cstv.networking.response.detail

import com.example.cstv.networking.response.match.MatchResponseItem
import com.example.cstv.networking.response.player.PlayerDetailResponse

data class DetailResponse(
    val playerDetailResponse: PlayerDetailResponse,
    val matchDetailResponse: MatchResponseItem
)