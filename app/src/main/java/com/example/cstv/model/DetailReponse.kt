package com.example.cstv.model

import com.example.cstv.model.matches.MatchResponseItem
import com.example.cstv.model.playersDetail.PlayerDetailResponse

data class DetailResponse(
    val playerDetailResponse: PlayerDetailResponse,
    val matchDetailResponse: MatchResponseItem
)