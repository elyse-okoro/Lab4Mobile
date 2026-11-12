package com.example.lab4mobile.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.lab4mobile.data.model.Place
import com.example.lab4mobile.databinding.ItemPlaceBinding

/** Список мест: название, значок и краткое описание. Используется на главной, в категории и в избранном. */
class PlaceAdapter(
    private val onClick: (Place) -> Unit
) : ListAdapter<Place, PlaceViewHolder>(PlaceDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
