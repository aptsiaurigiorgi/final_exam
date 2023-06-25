package com.rajendra.onlinedailygroceries.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.rajendra.onlinedailygroceries.ProductDetails
import com.rajendra.onlinedailygroceries.R
import com.rajendra.onlinedailygroceries.model.RecentlyViewed


class RecentlyViewedAdapter(
        private val context: Context,
        private val recentlyViewedList: List<RecentlyViewed>
) : RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewedViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentlyViewedViewHolder {
                val view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_items, parent, false)
                return RecentlyViewedViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecentlyViewedViewHolder, position: Int) {
                val recentlyViewed = recentlyViewedList[position]

                holder.name.text = recentlyViewed.name
                holder.description.text = recentlyViewed.description
                holder.price.text = recentlyViewed.price
                holder.qty.text = recentlyViewed.quantity
                holder.unit.text = recentlyViewed.unit
                holder.bg.setBackgroundResource(recentlyViewed.imageUrl)

                holder.itemView.setOnClickListener {
                        val intent = Intent(context, ProductDetails::class.java)
                        intent.putExtra("name", recentlyViewed.name)
                        intent.putExtra("image", recentlyViewed.imageUrl)
                        intent.putExtra("price", recentlyViewed.price)
                        intent.putExtra("desc", recentlyViewed.description)
                        intent.putExtra("qty", recentlyViewed.quantity)
                        intent.putExtra("unit", recentlyViewed.unit)
                        context.startActivity(intent)
                }
        }

        override fun getItemCount(): Int {
                return recentlyViewedList.size
        }

        class RecentlyViewedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                val name: TextView = itemView.findViewById(R.id.product_name)
                val description: TextView = itemView.findViewById(R.id.description)
                val price: TextView = itemView.findViewById(R.id.price)
                val qty: TextView = itemView.findViewById(R.id.qty)
                val unit: TextView = itemView.findViewById(R.id.unit)
                val bg: ConstraintLayout = itemView.findViewById(R.id.recently_layout)
        }
}
