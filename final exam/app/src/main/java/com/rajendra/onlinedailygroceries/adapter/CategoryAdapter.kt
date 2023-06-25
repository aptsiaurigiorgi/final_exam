package com.rajendra.onlinedailygroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.rajendra.onlinedailygroceries.R
import com.rajendra.onlinedailygroceries.model.Category

class CategoryAdapter(private val context: Context, private val categoryList: List<Category>) :
        RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
                val view = LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false)
                return CategoryViewHolder(view)
        }

        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
                holder.categoryImage.setImageResource(categoryList[position].imageurl!!)
        }

        override fun getItemCount(): Int {
                return categoryList.size
        }

        class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                val categoryImage: ImageView = itemView.findViewById(R.id.categoryImage)
        }
}
