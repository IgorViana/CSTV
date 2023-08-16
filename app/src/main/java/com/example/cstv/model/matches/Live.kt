package com.example.cstv.model.matches

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Live(
    val opens_at: @RawValue Any?,
    val supported: Boolean,
    val url: @RawValue Any?
) : Parcelable