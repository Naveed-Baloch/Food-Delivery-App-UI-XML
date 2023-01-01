package com.example.foodappui.model

import com.example.foodappui.model.Order

class User(
    val name: String,
    val orders: List<Order>,
    val cart: List<Order>
)
