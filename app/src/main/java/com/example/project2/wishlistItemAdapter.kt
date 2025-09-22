package com.example.project2

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class WishlistItemAdapter(private val wishlistItems: MutableList<WishlistItem>): RecyclerView.Adapter<WishlistItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val wishlistView = inflater.inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(wishlistView)
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wishlistItem = wishlistItems.get(position)
        // Set item views based on views and data model
        holder.itemName.text = wishlistItem.itemName
        holder.itemPrice.text = wishlistItem.itemPrice
        holder.itemLink.text = wishlistItem.itemLink
    }

    override fun getItemCount(): Int {
        return wishlistItems.size
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemName: TextView
        val itemPrice: TextView
        val itemLink: TextView

        // We also create a constructor that accepts the entire item row and does the view lookups to find each sub-view
        init {
            itemName = itemView.findViewById(R.id.itemNameTV)
            itemPrice = itemView.findViewById(R.id.itemPriceTV)
            itemLink = itemView.findViewById(R.id.itemLinkTV)
        }
    }
}