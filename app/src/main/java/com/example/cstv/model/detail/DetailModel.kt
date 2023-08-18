package com.example.cstv.model.detail

import com.example.cstv.model.match.MatchModel
import com.example.cstv.model.player.PlayerListModel

data class DetailModel(
    val playerListModel: PlayerListModel,
    val matchModel: MatchModel
)
