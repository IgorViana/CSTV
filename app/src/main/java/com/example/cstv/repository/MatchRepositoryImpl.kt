package com.example.cstv.repository

import com.example.cstv.model.matches.MatchResponse
import com.example.cstv.model.matches.MatchResponseItem
import com.example.cstv.networking.MatchService
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MatchRepositoryImpl(private val networking: MatchService) : IMatchRepository {

    override fun getMatches(): Flow<Result<MatchResponse>> = flow {
        emit(Result.Loading(true))
        try {
            val result = networking.getMatchesList()
            emit(Result.Success(result))
        } catch (exception: Exception) {
            emit(Result.Error(exception.message.toString()))
        } finally {
            emit(Result.Loading(false))
        }

    }.catch { ex: Throwable ->
        emit(Result.Error(ex.message.toString()))
    }

    override fun getMatchById(matchId: Long): Flow<Result<MatchResponseItem>> = flow {
        emit(Result.Loading(true))
        try {
            val result = networking.getMatchById(matchId)
            emit(Result.Success(result))
        } catch (exception: Exception) {
            emit(Result.Error(exception.message.toString()))
        } finally {
            emit(Result.Loading(false))
        }

    }.catch { ex: Throwable ->
        emit(Result.Error(ex.message.toString()))
    }
}
