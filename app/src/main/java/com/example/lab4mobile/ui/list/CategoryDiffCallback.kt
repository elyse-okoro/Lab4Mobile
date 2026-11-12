package com.example.lab4mobile.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.example.lab4mobile.data.model.Category

class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean = oldItem == newItem
}
