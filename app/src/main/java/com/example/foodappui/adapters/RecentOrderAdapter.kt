package com.example.foodappui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappui.databinding.RecentOrderItemBinding
import com.example.foodappui.model.Order

class RecentOrderAdapter(private val orders: List<Order>) :
    RecyclerView.Adapter<RecentOrderAdapter.RecentOrderVH>() {

    class RecentOrderVH(private val binding: RecentOrderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(order: Order) {
            binding.title.text = order.food.name
            binding.restaurantName.text = order.restaurant.name
            binding.date.text = order.date
            binding.foodImage.setImageResource(order.food.image)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecentOrderVH {
        val binding =
            RecentOrderItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return RecentOrderVH(binding)
    }

    override fun onBindViewHolder(viewHolder: RecentOrderVH, position: Int) {
        val order = orders[position]
        viewHolder.bind(order)
    }

    override fun getItemCount(): Int {
        return orders.size
    }
}