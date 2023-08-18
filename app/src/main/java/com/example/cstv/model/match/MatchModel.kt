package com.example.cstv.model.match

data class MatchModel(
    val beginAt: String?,
    val status: String,
    val teams: List<TeamModel>?,
    val league: LeagueModel,
    val seriesName: String?,
    val matchId: Long
)
