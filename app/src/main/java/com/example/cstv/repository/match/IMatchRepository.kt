package com.example.cstv.repository.match

import com.example.cstv.model.MatchResponse
import kotlinx.coroutines.flow.Flow

interface IMatchRepository {

    fun getMatches(): Flow<MatchResponse>
}