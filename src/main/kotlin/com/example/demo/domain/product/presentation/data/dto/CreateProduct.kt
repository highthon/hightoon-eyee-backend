package com.example.demo.domain.product.presentation.data.dto

import java.util.Locale.Category

data class CreateProduct(
    val title: String,
    val price: String,
    val category: String
)