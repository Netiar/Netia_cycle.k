package com.example.netia_cyclek.adapters

import android.text.format.DateUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.netia_cyclek.databinding.NetiaBinding
import com.example.netia_cyclek.models.Netia

class NetiaViewHolder(
    private val binding: NetiaBinding,
    private val startTime: Long
) : RecyclerView.ViewHolder(binding.root)  {
    fun bindTo(netia: Netia) {
        val elapsedSeconds = (netia.timestamp - startTime) / 1000

        binding.timestamp.text = DateUtils.formatElapsedTime(elapsedSeconds)
        binding.message.text = netia.message
        binding.activityHash.text = Integer.toHexString(netia.activityHash)
        binding.viewHash.text = Integer.toHexString(netia.viewHash)
    }
}