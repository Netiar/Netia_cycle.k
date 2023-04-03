package com.example.netia_cyclek.viewmodel

import android.os.SystemClock
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.netia_cyclek.models.Netia
import java.util.*

private const val STATE_NETIA = "netia"
private const val STATE_START_TIME = "startTime"


class NetiaViewModel(private val state: SavedStateHandle) : ViewModel(){

    val netia: ArrayList<Netia> = state[STATE_NETIA] ?: arrayListOf()
    val startTime: Long = state[STATE_START_TIME]
        ?: SystemClock.elapsedRealtime().also { state[STATE_START_TIME] = it }
    private val id = Random().nextInt()

    fun addEvent(message: String, activityHash: Int) {
        netia.add(Netia(message, activityHash, id))
        state[STATE_NETIA] = netia
    }

    override fun onCleared() {
        netia.clear()
    }
}