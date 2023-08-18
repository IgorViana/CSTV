package com.example.cstv.repository

import com.example.cstv.model.match.MatchListModel
import com.example.cstv.model.match.MatchModel
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow

interface IMatchRepository {

    fun getMatches(apiKey: String): Flow<Result<MatchListModel>>

    fun getMatchById(matchId: Long, apiKey: String): Flow<Result<MatchModel>>
}