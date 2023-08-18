package com.example.cstv.networking

import com.example.cstv.networking.response.player.PlayerDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlayerService {

    @GET("matches/{matchId}/opponents")
    suspend fun getPlayersByMatch(
        @Path("matchId") matchId: Long,
        @Query("token") key: String
    ): PlayerDetailResponse
}