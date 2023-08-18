package com.example.cstv.util

import com.example.cstv.model.match.LeagueModel
import com.example.cstv.model.match.MatchListModel
import com.example.cstv.model.match.MatchModel
import com.example.cstv.model.match.TeamModel
import com.example.cstv.model.player.PlayerListModel
import com.example.cstv.model.player.PlayerModel
import com.example.cstv.model.player.TeamPlayerModel
import com.example.cstv.networking.response.match.MatchResponse
import com.example.cstv.networking.response.match.MatchResponseItem
import com.example.cstv.networking.response.player.PlayerDetailResponse

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

    fun mapMatchResponseToModel(response: MatchResponseItem): MatchModel {
        val teams: MutableList<TeamModel> = mutableListOf()
        response.opponents?.forEach { opponent ->
            teams.add(
                TeamModel(
                    imageUrl = opponent.opponent.imageUrl,
                    name = opponent.opponent.name
                )
            )
        }


        return MatchModel(
            beginAt = response.beginAt,
            status = response.status,
            teams = teams,
            league = LeagueModel(
                name = response.league.name,
                imageUrl = response.league.imageUrl
            ),
            seriesName = response.serie.name,
            matchId = response.games[0].matchId
        )

    }

    fun mapPlayerResponseToModel(response: PlayerDetailResponse): PlayerListModel {

        val teams: MutableList<TeamPlayerModel> = mutableListOf()
        response.opponents.forEach { opponent ->

            val players: MutableList<PlayerModel> = mutableListOf()
            opponent.players.forEach { player ->
                players.add(
                    PlayerModel(
                        firstName = player.firstName,
                        lastName = player.lastName,
                        imageUrl = player.imageUrl,
                        slug = player.slug,
                        name = player.name
                    )
                )
            }

            teams.add(TeamPlayerModel(players = players))
        }

        return PlayerListModel(
            teams = teams
        )
    }
}