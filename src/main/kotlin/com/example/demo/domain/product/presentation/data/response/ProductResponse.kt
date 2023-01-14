package com.example.demo.domain.product.presentation.data.response

import com.example.demo.domain.product.domain.entity.Product

class ProductResponse(
    val id: Long,
    val title: String,
    val price: String
) {
    constructor(product: Product) : this(
        id = product.id,
        title = product.title,
        price = product.price
    )
}