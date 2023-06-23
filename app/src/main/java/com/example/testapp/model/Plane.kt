package com.example.testapp.model

import androidx.annotation.DrawableRes

data class Plane(
    val name: String,
    val year: Int?,
    @DrawableRes val imagePreview: Int,
    @DrawableRes val imageBody: Int?,
    val description: String
)
