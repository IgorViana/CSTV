package com.example.cstv.model.matchesDetail

data class Serie(
    val begin_at: String,
    val end_at: String,
    val full_name: String,
    val id: Int,
    val league_id: Int,
    val modified_at: String,
    val name: Any,
    val season: String,
    val slug: String,
    val winner_id: Int,
    val winner_type: String,
    val year: Int
)