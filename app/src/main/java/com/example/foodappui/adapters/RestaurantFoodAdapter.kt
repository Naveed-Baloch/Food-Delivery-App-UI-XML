package com.example.foodappui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappui.databinding.FoodItemBinding
import com.example.foodappui.databinding.RestaurantItemBinding
import com.example.foodappui.model.Food
import com.example.foodappui.model.Restaurant

class RestaurantFoodAdapter(private val restaurants: List<Food>) :
    RecyclerView.Adapter<RestaurantFoodAdapter.RestaurantVH>() {

    class RestaurantVH(private val binding: FoodItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(food: Food) {
            binding.foodName.text = food.name
            binding.price.text = food.price.toString()
            binding.foodItem.setImageResource(food.image)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RestaurantVH {
        val binding =
            FoodItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return RestaurantVH(binding)
    }

    override fun onBindViewHolder(viewHolder: RestaurantVH, position: Int) {
        val food = restaurants[position]
        viewHolder.bind(food)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}