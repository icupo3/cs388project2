package com.example.project2

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.view.WindowManager
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var wishlistItems: MutableList<WishlistItem>
    private lateinit var adapter: WishlistItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // code here
        val wishlistRV = findViewById<RecyclerView>(R.id.wishlistRV)
        val addItemBtn = findViewById<Button>(R.id.addItemBtn)
        val itemNameBox = findViewById<EditText>(R.id.itemNameBox)
        val itemPriceBox = findViewById<EditText>(R.id.itemPriceBox)
        val itemLinkBox = findViewById<EditText>(R.id.itemLinkBox)

        wishlistItems = mutableListOf()
        adapter = WishlistItemAdapter(wishlistItems)
        wishlistRV.layoutManager = LinearLayoutManager(this)
        wishlistRV.adapter = adapter

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        addItemBtn.setOnClickListener {
            val itemNameText = itemNameBox.text.toString()
            val itemPriceText = itemPriceBox.text.toString()
            val itemLinkText = itemLinkBox.text.toString()


            if(itemNameText != "" && itemPriceText != "" && itemLinkText != "") {
                val newItem = WishlistItem(
                    itemNameBox.text.toString(),
                    itemPriceBox.text.toString(),
                    itemLinkBox.text.toString()
                )

                wishlistItems.add(newItem)
                adapter.notifyItemInserted(wishlistItems.size - 1)

                itemNameBox.text.clear()
                itemPriceBox.text.clear()
                itemLinkBox.text.clear()
            }
            else{
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}