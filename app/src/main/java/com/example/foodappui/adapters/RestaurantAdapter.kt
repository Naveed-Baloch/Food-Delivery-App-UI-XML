package com.example.foodappui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappui.R
import com.example.foodappui.model.Restaurant
import com.example.foodappui.ui.HomeFragmentDirections
import kotlinx.android.synthetic.main.restaurant_item.view.*

class RestaurantAdapter(private val dataSet: List<Restaurant>) :
    RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val restaurantName: TextView
        val restaurantAddress: TextView
        val restaurantDistance: TextView
        val rvRatingBar: RecyclerView
        val restaurantImage = view.findViewById(R.id.food_image) as ImageView

        init {
            restaurantName = view.findViewById(R.id.restaurant_name)
            restaurantAddress = view.findViewById(R.id.restaurant_address)
            restaurantDistance = view.findViewById(R.id.restaurant_distance)
            rvRatingBar = view.findViewById(R.id.rv_rating)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.restaurant_item, viewGroup, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val restaurant = dataSet[position]
        viewHolder.restaurantName.text = restaurant.name
        viewHolder.restaurantAddress.text = restaurant.address
        viewHolder.restaurantDistance.text = ".3 Km Away"
        viewHolder.restaurantImage.setImageResource(restaurant.image)
        viewHolder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToRestaurantFragment2(restaurant)
            viewHolder.itemView.findNavController().navigate(action)
        }
        viewHolder.rvRatingBar.layoutManager =
            LinearLayoutManager(viewHolder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        viewHolder.rvRatingBar.adapter = RatingAdapter(restaurant.rating)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}