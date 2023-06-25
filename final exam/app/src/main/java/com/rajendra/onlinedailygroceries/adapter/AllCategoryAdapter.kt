package com.rajendra.onlinedailygroceries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.rajendra.onlinedailygroceries.R
import com.rajendra.onlinedailygroceries.model.AllCategoryModel

class AllCategoryAdapter(private val context: Context, private val categoryList: List<AllCategoryModel>) :
        RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCategoryViewHolder {
                val view = LayoutInflater.from(context).inflate(R.layout.all_category_row_items, parent, false)
                return AllCategoryViewHolder(view)
        }

        override fun onBindViewHolder(holder: AllCategoryViewHolder, position: Int) {
                holder.categoryImage.setImageResource(categoryList[position].imageurl!!)
        }

        override fun getItemCount(): Int {
                return categoryList.size
        }

        class AllCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                val categoryImage: ImageView = itemView.findViewById(R.id.categoryImage)
        }
}
