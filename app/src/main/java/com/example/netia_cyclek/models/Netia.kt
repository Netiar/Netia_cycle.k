package com.example.netia_cyclek.models

import android.os.Parcelable
import android.os.SystemClock
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Netia(
    val message: String,
    val activityHash: Int,
    val viewHash: Int,
    val timestamp: Long = SystemClock.elapsedRealtime()
) : Parcelable