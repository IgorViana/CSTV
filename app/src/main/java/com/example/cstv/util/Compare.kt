package com.example.cstv.util

import com.example.cstv.model.match.MatchModel

class Compare {

    companion object : Comparator<MatchModel> {

        override fun compare(a: MatchModel, b: MatchModel): Int = when {
            a.status == RUNNING && b.status == RUNNING -> 0
            a.status == RUNNING && b.status != RUNNING -> -1
            else -> 1
        }

        private const val RUNNING = "running"
    }
}