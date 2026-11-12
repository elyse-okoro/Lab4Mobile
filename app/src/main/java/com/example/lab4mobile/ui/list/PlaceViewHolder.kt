package com.example.lab4mobile.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.example.lab4mobile.data.model.Place
import com.example.lab4mobile.databinding.ItemPlaceBinding

class PlaceViewHolder(
    private val binding: ItemPlaceBinding,
    onClick: (Place) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var place: Place? = null

    init {
        binding.root.setOnClickListener { place?.let(onClick) }
    }

    fun bind(item: Place) {
        place = item
        binding.placeIcon.setImageResource(item.iconRes)
        binding.placeName.setText(item.nameRes)
        binding.placeSummary.setText(item.summaryRes)
    }
}
