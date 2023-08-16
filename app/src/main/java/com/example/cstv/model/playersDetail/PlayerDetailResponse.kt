package com.example.cstv.model.playersDetail

data class PlayerDetailResponse(
    val opponent_type: String,
    val opponents: List<Opponent>
)