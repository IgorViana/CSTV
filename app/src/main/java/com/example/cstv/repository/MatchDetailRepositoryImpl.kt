package com.example.cstv.repository

import com.example.cstv.model.detail.DetailModel
import com.example.cstv.networking.MatchService
import com.example.cstv.networking.PlayerService
import com.example.cstv.util.Mapper
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MatchDetailRepositoryImpl(
    private val networking: PlayerService,
    private val matchNetworking: MatchService
) : IMatchDetailRepository {
    override fun getPlayersStatsByMatch(matchId: Long, apiKey: String): Flow<Result<DetailModel>> =
        flow {
            emit(Result.Loading(true))
            try {
                val playerResponse = networking.getPlayersByMatch(matchId = matchId, key = apiKey)
                val playerModel = Mapper().mapPlayerResponseToModel(playerResponse)

                val matchResponse = matchNetworking.getMatchById(matchId = matchId, key = apiKey)
                val matchModel = Mapper().mapMatchResponseToModel(matchResponse)

                emit(
                    Result.Success(
                        DetailModel(
                            playerListModel = playerModel,
                            matchModel = matchModel
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