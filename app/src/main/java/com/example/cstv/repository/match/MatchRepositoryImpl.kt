package com.example.cstv.repository.match

import com.example.cstv.model.MatchResponse
import com.example.cstv.networking.MatchService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MatchRepositoryImpl(private val networking: MatchService) : IMatchRepository {

    override fun getMatches(): Flow<MatchResponse> = flow {
        val result = networking.getMatchesList()
        emit(result)
    }.flowOn(Dispatchers.IO)

}