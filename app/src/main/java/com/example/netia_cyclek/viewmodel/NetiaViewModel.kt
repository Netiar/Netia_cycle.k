package com.example.netia_cyclek.viewmodel

import android.os.SystemClock
import androidx.lifecycle.ViewModel
import com.example.netia_cyclek.models.Netia
import java.util.*

class NetiaViewModel : ViewModel() {
    val netia: MutableList<Netia> = mutableListOf()
    val startTime = SystemClock.elapsedRealtime()
    private val id = Random().nextInt()

    fun addEvent(message: String, activityHash: Int) {
        netia.add(Netia(message, activityHash, id))
    }

    override fun onCleared() {
        netia.clear()
    }
}