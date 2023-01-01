package com.example.foodappui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappui.R
import com.example.foodappui.model.Order

class RecentOrderAdapter(private val dataSet: List<Order>) :
    RecyclerView.Adapter<RecentOrderAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodTextView: TextView
        val restaurant: TextView
        val date: TextView
        val foodImage = view.findViewById(R.id.food_image) as ImageView

        init {
            foodTextView = view.findViewById(R.id.title)
            restaurant = view.findViewById(R.id.restaurant_name)
            date = view.findViewById(R.id.date)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recent_order_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val order = dataSet[position]
        viewHolder.foodTextView.text = order.food.name
        viewHolder.restaurant.text = order.restaurant.name
        viewHolder.date.text = order.date
        viewHolder.foodImage.setImageResource(order.food.image)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}