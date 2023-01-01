package com.example.foodappui.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(
     val image: Int,
     val name: String,
     val address: String,
     val rating: Int,
     val menu: List<Food>
):Parcelable