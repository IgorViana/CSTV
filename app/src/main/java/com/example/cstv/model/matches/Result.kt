package com.example.cstv.model.matches

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val score: Int,
    val team_id: Int
) : Parcelable