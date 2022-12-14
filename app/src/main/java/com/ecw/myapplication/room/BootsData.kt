package com.bam.shopproject.room


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BootsData(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    var price: Double,
    var description: String,
    val img: String,
    var favorite: Boolean
)