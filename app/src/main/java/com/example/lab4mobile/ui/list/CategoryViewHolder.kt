package com.example.lab4mobile.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.example.lab4mobile.R
import com.example.lab4mobile.data.model.Category
import com.example.lab4mobile.databinding.ItemCategoryBinding

class CategoryViewHolder(
    private val binding: ItemCategoryBinding,
    private val placesCount: (Category) -> Int,
    onClick: (Category) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var category: Category? = null

    init {
        binding.root.setOnClickListener { category?.let(onClick) }
    }

    fun bind(item: Category) {
        category = item
        val count = placesCount(item)
        binding.categoryIcon.setImageResource(item.iconRes)
        binding.categoryTitle.setText(item.titleRes)
        binding.categoryDescription.setText(item.descriptionRes)
        binding.categoryCount.text =
            binding.root.resources.getQuantityString(R.plurals.places_count, count, count)
    }
}
