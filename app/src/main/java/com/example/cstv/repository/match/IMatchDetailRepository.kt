package com.example.cstv.repository.match

import com.example.cstv.model.DetailResponse
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow

interface IMatchDetailRepository {

    fun getPlayersStatsByMatch(matchId: Long): Flow<Result<DetailResponse>>
}