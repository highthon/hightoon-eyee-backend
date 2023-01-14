package com.example.demo.domain.product.presentation.data.request

import java.util.Locale.Category

data class CreateProductRequest(
    val title: String,
    val price: String,
    val category: String
)
