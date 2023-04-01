package com.example.netia_cyclek.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.netia_cyclek.databinding.NetiaBinding
import com.example.netia_cyclek.models.Netia

internal class NetiaAdapter(
    private val inflater: LayoutInflater,
    private val startTime: Long
) : ListAdapter<Netia, NetiaViewHolder>(NetiaDiffer) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = NetiaViewHolder(NetiaBinding.inflate(inflater, parent, false), startTime)


    override fun onBindViewHolder(holder: NetiaViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    private object NetiaDiffer : DiffUtil.ItemCallback<Netia>() {
        override fun areItemsTheSame(oldEvent: Netia, newEvent: Netia) =
            oldEvent === newEvent

        override fun areContentsTheSame(oldEvent: Netia, newEvent: Netia) =
            oldEvent == newEvent
    }

}