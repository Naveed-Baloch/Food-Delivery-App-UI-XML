package com.example.foodappui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodappui.R
import com.example.foodappui.databinding.RatingBarBinding

class RatingAdapter(private val rating: Int) :
    RecyclerView.Adapter<RatingAdapter.RatingViewHolder>() {

    class RatingViewHolder(private val binding: RatingBarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(){
            binding.ratingStar.setImageResource(R.drawable.ic_star)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RatingViewHolder {
        val binding = RatingBarBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return RatingViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: RatingViewHolder, position: Int) {
        viewHolder.bind()
    }

    override fun getItemCount(): Int {
        return rating
    }
}