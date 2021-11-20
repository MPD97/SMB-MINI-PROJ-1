package com.example.smb_mini_proj_1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name: String,
    var price: Double,
    var amount: Int,
    var isBought: Boolean
)