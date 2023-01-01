package com.example.foodappui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappui.adapters.RestaurantFoodAdapter
import com.example.foodappui.databinding.FragmentRestaurantBinding
import com.example.foodappui.model.Restaurant


class RestaurantFragment : Fragment() {

    private var binding: FragmentRestaurantBinding? = null
    private var restaurant: Restaurant? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            restaurant = it.getParcelable("restaurant")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restaurant?.let {
            binding?.restaurantCover?.setImageResource(it.image)
            binding?.restaurantName?.text = it.name
            binding?.restaurantAddress?.text = it.address
            val restaurantFoodAdapter = RestaurantFoodAdapter(it.menu)
            val foodGridView: RecyclerView = binding?.gridRestaurant!!
            foodGridView.layoutManager = GridLayoutManager(requireContext(), 2)
            foodGridView.adapter = restaurantFoodAdapter
        }

        binding?.backBtn?.setOnClickListener {
            view.findNavController().popBackStack()
        }
    }
}