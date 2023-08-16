package com.example.cstv.model.matches

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Videogame(
    val id: Int,
    val name: String,
    val slug: String
) : Parcelable