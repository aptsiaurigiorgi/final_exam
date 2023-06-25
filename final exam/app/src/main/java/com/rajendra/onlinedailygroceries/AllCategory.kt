package com.rajendra.onlinedailygroceries

import android.content.Intent
import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rajendra.onlinedailygroceries.adapter.AllCategoryAdapter
import com.rajendra.onlinedailygroceries.model.AllCategoryModel
import java.util.*

class AllCategory : AppCompatActivity() {

    private lateinit var allCategoryRecycler: RecyclerView
    private lateinit var allCategoryAdapter: AllCategoryAdapter
    private lateinit var allCategoryModelList: MutableList<AllCategoryModel>
    private lateinit var back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_category)

        allCategoryRecycler = findViewById(R.id.all_category)
        back = findViewById(R.id.back)

        back.setOnClickListener {
            val backIntent = Intent(this@AllCategory, MainActivity::class.java)
            startActivity(backIntent)
            finish()
        }

        // adding data to model
        allCategoryModelList = mutableListOf()
        allCategoryModelList.add(AllCategoryModel(1, R.drawable.ic_fruits))
        allCategoryModelList.add(AllCategoryModel(2, R.drawable.ic_veggies))
        allCategoryModelList.add(AllCategoryModel(3, R.drawable.ic_meat))
        allCategoryModelList.add(AllCategoryModel(4, R.drawable.ic_fish))
        allCategoryModelList.add(AllCategoryModel(5, R.drawable.ic_spices))
        allCategoryModelList.add(AllCategoryModel(6, R.drawable.ic_egg))
        allCategoryModelList.add(AllCategoryModel(7, R.drawable.ic_drink))
        allCategoryModelList.add(AllCategoryModel(8, R.drawable.ic_cookies))
        allCategoryModelList.add(AllCategoryModel(8, R.drawable.ic_juce))

        setCategoryRecycler(allCategoryModelList)
    }

    private fun setCategoryRecycler(allCategoryModelList: List<AllCategoryModel>) {
        val layoutManager = GridLayoutManager(this, 4)
        allCategoryRecycler.layoutManager = layoutManager
        allCategoryRecycler.addItemDecoration(GridSpacingItemDecoration(4, dpToPx(16), true))
        allCategoryRecycler.itemAnimator = DefaultItemAnimator()
        allCategoryAdapter = AllCategoryAdapter(this, allCategoryModelList)
        allCategoryRecycler.adapter = allCategoryAdapter
    }

    // now we need some item decoration class for managing spacing
    inner class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int, private val includeEdge: Boolean) :
        RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val position = parent.getChildAdapterPosition(view) // item position
            val column = position % spanCount // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing
                }
                outRect.bottom = spacing // item bottom
            } else {
                outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f / spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing // item top
                }
            }
        }
    }

    private fun dpToPx(dp: Int): Int {
        val r: Resources = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }
}
