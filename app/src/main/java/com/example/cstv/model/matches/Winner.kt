package com.example.cstv.model.matches

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Winner(
    val id: Int,
    val type: String
):Parcelable