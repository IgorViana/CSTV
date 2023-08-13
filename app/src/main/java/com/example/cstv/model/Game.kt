package com.example.cstv.model

data class Game(
    val begin_at: String,
    val complete: Boolean,
    val detailed_stats: Boolean,
    val end_at: String,
    val finished: Boolean,
    val forfeit: Boolean,
    val id: Int,
    val length: Any,
    val match_id: Int,
    val position: Int,
    val status: String,
    val winner: Winner,
    val winner_type: String
)