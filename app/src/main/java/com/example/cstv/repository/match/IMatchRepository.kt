package com.example.cstv.repository.match

import com.example.cstv.model.matches.MatchResponse
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow

interface IMatchRepository {

    fun getMatches(): Flow<Result<MatchResponse>>
}