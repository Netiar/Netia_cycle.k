package com.example.netia_cyclek.models

import android.os.SystemClock

data class Netia(
    val message: String,
    val activityHash: Int,
    val viewHash: Int,
    val timestamp: Long = SystemClock.elapsedRealtime()
)