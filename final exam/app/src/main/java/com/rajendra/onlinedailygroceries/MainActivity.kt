package com.rajendra.onlinedailygroceries

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rajendra.onlinedailygroceries.adapter.CategoryAdapter
import com.rajendra.onlinedailygroceries.adapter.DiscountedProductAdapter
import com.rajendra.onlinedailygroceries.adapter.RecentlyViewedAdapter
import com.rajendra.onlinedailygroceries.model.Category
import com.rajendra.onlinedailygroceries.model.DiscountedProducts
import com.rajendra.onlinedailygroceries.model.RecentlyViewed

class MainActivity : AppCompatActivity() {

private lateinit var discountRecyclerView: RecyclerView
private lateinit var categoryRecyclerView: RecyclerView
private lateinit var allCategory: TextView
private lateinit var recentlyViewedRecycler: RecyclerView

private lateinit var discountedProductAdapter: DiscountedProductAdapter
private lateinit var discountedProductsList: MutableList<DiscountedProducts>

private lateinit var categoryAdapter: CategoryAdapter
private lateinit var categoryList: MutableList<Category>

private lateinit var recentlyViewedAdapter: RecentlyViewedAdapter
private lateinit var recentlyViewedList: MutableList<RecentlyViewed>

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            discountRecyclerView = findViewById(R.id.discountedRecycler)
            categoryRecyclerView = findViewById(R.id.categoryRecycler)
            allCategory = findViewById(R.id.allCategoryImage)
            recentlyViewedRecycler = findViewById(R.id.recently_item)

            allCategory.setOnClickListener {
            val intent = Intent(this@MainActivity, AllCategory::class.java)
        startActivity(intent)
        }

        discountedProductsList = mutableListOf()
        discountedProductsList.add(DiscountedProducts(1, R.drawable.discountberry))
        discountedProductsList.add(DiscountedProducts(2, R.drawable.discountbrocoli))
        discountedProductsList.add(DiscountedProducts(3, R.drawable.discountmeat))
        discountedProductsList.add(DiscountedProducts(4, R.drawable.discountberry))
        discountedProductsList.add(DiscountedProducts(5, R.drawable.discountbrocoli))
        discountedProductsList.add(DiscountedProducts(6, R.drawable.discountmeat))

        categoryList = mutableListOf()
        categoryList.add(Category(1, R.drawable.ic_home_fruits))
        categoryList.add(Category(2, R.drawable.ic_home_fish))
        categoryList.add(Category(3, R.drawable.ic_home_meats))
        categoryList.add(Category(4, R.drawable.ic_home_veggies))
        categoryList.add(Category(5, R.drawable.ic_home_fruits))
        categoryList.add(Category(6, R.drawable.ic_home_fish))
        categoryList.add(Category(7, R.drawable.ic_home_meats))
        categoryList.add(Category(8, R.drawable.ic_home_veggies))

        recentlyViewedList = mutableListOf()
        recentlyViewedList.add(
        RecentlyViewed(
        "Watermelon",
        "Watermelon has high water content and also provides some fiber.",
        "₾ 80",
        "1",
        "KG",
        R.drawable.card4,
        R.drawable.b4
        )
        )
        recentlyViewedList.add(
        RecentlyViewed(
        "Papaya",
        "Papayas are spherical or pear-shaped fruits that can be as long as 20 inches.",
        "₾ 85",
        "1",
        "KG",
        R.drawable.card3,
        R.drawable.b3
        )
        )
        recentlyViewedList.add(
        RecentlyViewed(
        "Strawberry",
        "The strawberry is a highly nutritious fruit, loaded with vitamin C.",
        "₾ 30",
        "1",
        "KG",
        R.drawable.card2,
        R.drawable.b1
        )
        )
        recentlyViewedList.add(
        RecentlyViewed(
        "Kiwi",
        "Full of nutrients like vitamin C, vitamin K, vitamin E, folate, and potassium.",
        "₾ 30",
        "1",
        "PC",
        R.drawable.card1,
        R.drawable.b2
        )
        )

        setDiscountedRecycler(discountedProductsList)
        setCategoryRecycler(categoryList)
        setRecentlyViewedRecycler(recentlyViewedList)
        }


    private fun setDiscountedRecycler(dataList: List<DiscountedProducts>) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        discountRecyclerView.layoutManager = layoutManager
        discountedProductAdapter = DiscountedProductAdapter(this, dataList)
        discountRecyclerView.adapter = discountedProductAdapter
        }

private fun setCategoryRecycler(categoryDataList: List<Category>) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.layoutManager = layoutManager
        categoryAdapter = CategoryAdapter(this, categoryDataList)
        categoryRecyclerView.adapter = categoryAdapter
        }

private fun setRecentlyViewedRecycler(recentlyViewedDataList: List<RecentlyViewed>) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recentlyViewedRecycler.layoutManager = layoutManager
        recentlyViewedAdapter = RecentlyViewedAdapter(this, recentlyViewedDataList)
        recentlyViewedRecycler.adapter = recentlyViewedAdapter
        }
        }
