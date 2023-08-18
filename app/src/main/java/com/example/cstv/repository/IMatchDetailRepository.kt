package com.example.cstv.repository

import com.example.cstv.model.detail.DetailModel
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow

interface IMatchDetailRepository {

    fun getPlayersStatsByMatch(matchId: Long): Flow<Result<DetailModel>>
}