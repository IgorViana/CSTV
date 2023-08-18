package com.example.cstv.repository

import com.example.cstv.model.match.MatchListModel
import com.example.cstv.model.match.MatchModel
import com.example.cstv.networking.MatchService
import com.example.cstv.util.Compare
import com.example.cstv.util.Mapper
import com.example.cstv.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MatchRepositoryImpl(private val networking: MatchService) : IMatchRepository {

    override fun getMatches(apiKey: String): Flow<Result<MatchListModel>> = flow {
        emit(Result.Loading(true))
        try {
            val result = networking.getMatchesList(key = apiKey)
            val model = Mapper().mapMatchResponseToModel(result)
            val listSorted = MatchListModel(model.matches?.sortedWith(Compare))
            emit(Result.Success(listSorted))
        } catch (exception: Exception) {
            emit(Result.Error(exception.message.toString()))
        } finally {
            emit(Result.Loading(false))
        }

    }.catch { ex: Throwable ->
        emit(Result.Error(ex.message.toString()))
    }

    override fun getMatchById(matchId: Long, apiKey: String): Flow<Result<MatchModel>> = flow {
        emit(Result.Loading(true))
        try {
            val result = networking.getMatchById(matchId = matchId, key = apiKey)
            val model = Mapper().mapMatchResponseToModel(result)
            emit(Result.Success(model))
        } catch (exception: Exception) {
            emit(Result.Error(exception.message.toString()))
        } finally {
            emit(Result.Loading(false))
        }

    }.catch { ex: Throwable ->
        emit(Result.Error(ex.message.toString()))
    }
}
