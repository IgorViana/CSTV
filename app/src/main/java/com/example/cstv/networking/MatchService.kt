package com.example.cstv.networking

import com.example.cstv.networking.response.match.MatchResponse
import com.example.cstv.networking.response.match.MatchResponseItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MatchService {

    @GET("csgo/matches?filter[status]=running,finished")
    suspend fun getMatchesList(@Query("token") key: String): MatchResponse

    @GET("matches/{matchId}")
    suspend fun getMatchById(
        @Path("matchId") matchId: Long,
        @Query("token") key: String
    ): MatchResponseItem
}