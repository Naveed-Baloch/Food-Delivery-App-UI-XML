package com.example.foodappui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappui.databinding.RestaurantItemBinding
import com.example.foodappui.model.Restaurant
import com.example.foodappui.ui.HomeFragmentDirections
import kotlinx.android.synthetic.main.restaurant_item.view.*

class RestaurantAdapter(private val restaurants: List<Restaurant>) :
    RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(val binding: RestaurantItemBinding) : RecyclerView.ViewHolder(binding.root) {
       @SuppressLint("SetTextI18n")
       fun bind(restaurant: Restaurant){
           binding.restaurantName.text = restaurant.name
           binding.restaurantAddress.text = restaurant.address
           binding.restaurantDistance.text = "0.3 Km Away"
           binding.foodImage.setImageResource(restaurant.image)
           binding.root.setOnClickListener {
               val action = HomeFragmentDirections.actionHomeFragment2ToRestaurantFragment2(restaurant)
               binding.root.findNavController().navigate(action)
           }
           binding.rvRating.layoutManager =
               LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
           binding.rvRating.adapter = RatingAdapter(restaurant.rating)
       }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = RestaurantItemBinding
            .inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return RestaurantViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurants[position]
        viewHolder.bind(restaurant)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }
}