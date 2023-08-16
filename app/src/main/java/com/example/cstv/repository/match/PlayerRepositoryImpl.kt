package com.example.cstv.repository.match

import com.example.cstv.model.playersDetail.PlayerDetailResponse
import com.example.cstv.networking.PlayerService
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class PlayerRepositoryImpl(private val networking: PlayerService) : IPlayerRepository {
    override fun getPlayersStatsByMatch(matchId: Long): Flow<Result<PlayerDetailResponse>> = flow {
        emit(Result.Loading(true))
        try {
            val result = networking.getPlayersByMatch(matchId)
            emit(Result.Success(result))
        } catch (exception: Exception) {
            emit(Result.Error(exception.message.toString()))
        } finally {
            emit(Result.Loading(false))
        }

    }.catch { ex: Throwable -> emit(Result.Error(ex.message.toString())) }
}