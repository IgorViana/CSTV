package com.example.cstv.repository

import com.example.cstv.networking.response.detail.DetailResponse
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow

interface IMatchDetailRepository {

    fun getPlayersStatsByMatch(matchId: Long): Flow<Result<DetailResponse>>
}