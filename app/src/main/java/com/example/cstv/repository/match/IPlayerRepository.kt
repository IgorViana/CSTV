package com.example.cstv.repository.match

import com.example.cstv.model.playersDetail.PlayerDetailResponse
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow

interface IPlayerRepository {

    fun getPlayersStatsByMatch(matchId: Long): Flow<Result<PlayerDetailResponse>>
}