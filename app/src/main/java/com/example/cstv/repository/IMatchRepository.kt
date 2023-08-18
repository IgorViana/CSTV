package com.example.cstv.repository

import com.example.cstv.networking.response.match.MatchResponse
import com.example.cstv.networking.response.match.MatchResponseItem
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow

interface IMatchRepository {

    fun getMatches(): Flow<Result<MatchResponse>>

    fun getMatchById(matchId: Long): Flow<Result<MatchResponseItem>>
}