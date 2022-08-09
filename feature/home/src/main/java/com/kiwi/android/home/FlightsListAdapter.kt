package com.kiwi.android.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiwi.android.home.databinding.ViewholderFlightBinding
import com.kiwi.android.home.model.UiFlight

class FlightsListAdapter :
    ListAdapter<UiFlight, FlightsListAdapter.FlightViewHolder>(ITEM_COMPARATOR) {

    inner class FlightViewHolder(
        private val binding: ViewholderFlightBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(uiFlight: UiFlight) {
            binding.uiFlight = uiFlight
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        return FlightViewHolder(
            ViewholderFlightBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<UiFlight>() {
    override fun areItemsTheSame(oldItem: UiFlight, newItem: UiFlight): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiFlight, newItem: UiFlight): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }
}