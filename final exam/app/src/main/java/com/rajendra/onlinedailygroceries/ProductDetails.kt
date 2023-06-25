package com.rajendra.onlinedailygroceries

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetails : AppCompatActivity() {

private lateinit var img: ImageView
private lateinit var back: ImageView
private lateinit var proName: TextView
private lateinit var proPrice: TextView
private lateinit var proDesc: TextView
private lateinit var proQty: TextView
private lateinit var proUnit: TextView

private var name: String? = null
private var price: String? = null
private var desc: String? = null
private var qty: String? = null
private var unit: String? = null
private var image: Int = 0

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val i = intent

        name = i.getStringExtra("name")
        image = i.getIntExtra("image", R.drawable.b1)
        price = i.getStringExtra("price")
        desc = i.getStringExtra("desc")
        qty = i.getStringExtra("qty")
        unit = i.getStringExtra("unit")

        proName = findViewById(R.id.productName)
        proDesc = findViewById(R.id.prodDesc)
        proPrice = findViewById(R.id.prodPrice)
        img = findViewById(R.id.big_image)
        back = findViewById(R.id.back2)
        proQty = findViewById(R.id.qty)
        proUnit = findViewById(R.id.unit)

        proName.text = name
        proPrice.text = price
        proDesc.text = desc
        proQty.text = qty
        proUnit.text = unit

        img.setImageResource(image)

        back.setOnClickListener(object : View.OnClickListener {
        override fun onClick(view: View) {
        val i = Intent(this@ProductDetails, MainActivity::class.java)
        startActivity(i)
        finish()
        }
        })
        }
        }