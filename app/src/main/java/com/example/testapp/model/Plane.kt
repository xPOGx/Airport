package com.example.testapp.model

import androidx.annotation.DrawableRes

/**
 * A data class to represent the information presented in the RecycleViews
 */
data class Plane(
    val name: String,
    val year: Int?,
    @DrawableRes val imagePreview: Int,
    @DrawableRes val imageBody: Int?,
    val description: String
)
