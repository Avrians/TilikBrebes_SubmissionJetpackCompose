package com.avrians.tilikbrebes.model

data class Wisata(
    val id: Int,
    val name: String,
    val location: String,
    val description: String,
    val image: Int,
    val rating: Double,
    val price: String,
    val openTime: String,
    val closeTime: String,
    val isFavorite: Boolean = false
)
