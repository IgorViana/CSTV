package com.example.cstv.util

import com.example.cstv.model.match.LeagueModel
import com.example.cstv.model.match.MatchListModel
import com.example.cstv.model.match.MatchModel
import com.example.cstv.model.match.TeamModel
import com.example.cstv.networking.response.match.MatchResponse

class Mapper {

    fun mapMatchResponseToModel(response: MatchResponse): MatchListModel {
        val matchList: MutableList<MatchModel> = mutableListOf()
        response.forEach { responseItem ->

            val teams: MutableList<TeamModel> = mutableListOf()
            responseItem.opponents?.forEach { opponent ->
                teams.add(
                    TeamModel(
                        imageUrl = opponent.opponent.imageUrl,
                        name = opponent.opponent.name
                    )
                )
            }

            matchList.add(
                MatchModel(
                    beginAt = responseItem.beginAt,
                    status = responseItem.status,
                    teams = teams,
                    league = LeagueModel(
                        name = responseItem.league.name,
                        imageUrl = responseItem.league.imageUrl
                    ),
                    seriesName = responseItem.serie.name,
                    matchId = responseItem.games[0].matchId
                )
            )
        }

        return MatchListModel(
            matches = matchList
        )
    }
}