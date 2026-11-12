package com.example.lab4mobile.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.lab4mobile.data.model.Category
import com.example.lab4mobile.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val placesCount: (Category) -> Int,
    private val onClick: (Category) -> Unit
) : ListAdapter<Category, CategoryViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, placesCount, onClick)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
