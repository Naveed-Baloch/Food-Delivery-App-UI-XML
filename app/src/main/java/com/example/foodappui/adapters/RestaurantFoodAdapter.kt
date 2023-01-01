package com.example.foodappui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappui.R
import com.example.foodappui.model.Food
import com.example.foodappui.model.Restaurant
import com.example.foodappui.ui.HomeFragmentDirections

class RestaurantFoodAdapter(private val dataSet: List<Food>) :
    RecyclerView.Adapter<RestaurantFoodAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodName: TextView
        val price: TextView
        val foodImage = view.findViewById(R.id.food_item) as ImageView

        init {
            foodName = view.findViewById(R.id.food_name)
            price = view.findViewById(R.id.price)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.food_item, viewGroup, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val food:Food = dataSet[position]
        viewHolder.foodName.text = food.name
        viewHolder.price.text= food.price.toString()
        viewHolder.foodImage.setImageResource(food.image)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}