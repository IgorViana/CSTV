package com.example.cstv.repository

import com.example.cstv.model.DetailResponse
import com.example.cstv.networking.MatchService
import com.example.cstv.networking.PlayerService
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MatchDetailRepositoryImpl(
    private val networking: PlayerService,
    private val matchNetworking: MatchService
) : IMatchDetailRepository {
    override fun getPlayersStatsByMatch(matchId: Long): Flow<Result<DetailResponse>> = flow {
        emit(Result.Loading(true))
        try {
            val player = networking.getPlayersByMatch(matchId)
            val match = matchNetworking.getMatchById(matchId)
            emit(
                Result.Success(
                    DetailResponse(
                        playerDetailResponse = player,
                        matchDetailResponse = match
                    )
                )
            )
        } catch (exception: Exception) {
            emit(Result.Error(exception.message.toString()))
        } finally {
            emit(Result.Loading(false))
        }

    }.catch { ex: Throwable -> emit(Result.Error(ex.message.toString())) }
}