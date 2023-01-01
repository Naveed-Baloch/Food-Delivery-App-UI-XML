package com.example.foodappui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappui.adapters.RecentOrderAdapter
import com.example.foodappui.adapters.RestaurantAdapter
import com.example.foodappui.adapters.RestaurantFoodAdapter
import com.example.foodappui.data.currentUser
import com.example.foodappui.data.restaurants
import com.example.foodappui.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    var binding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recentOrderAdapter = RecentOrderAdapter(currentUser.orders)
        val restaurantAdapter = RestaurantAdapter(restaurants)
        // recent orders
        val rvRecentOrder: RecyclerView = binding?.rvRecentOrder!!
        rvRecentOrder.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvRecentOrder.adapter = recentOrderAdapter

        // restaurants
        val rvRestaurants: RecyclerView = binding?.rvRestaurants!!
        rvRestaurants.layoutManager = LinearLayoutManager(requireContext())
        rvRestaurants.adapter = restaurantAdapter
    }
}