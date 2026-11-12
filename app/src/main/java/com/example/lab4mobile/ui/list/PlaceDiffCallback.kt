package com.example.lab4mobile.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.example.lab4mobile.data.model.Place

class PlaceDiffCallback : DiffUtil.ItemCallback<Place>() {
    override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean = oldItem == newItem
}
