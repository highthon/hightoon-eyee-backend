package com.example.demo.domain.product.util

import com.example.demo.domain.product.domain.entity.Product
import com.example.demo.domain.product.presentation.data.dto.CreateProduct
import com.example.demo.domain.product.presentation.data.dto.GetProduct
import com.example.demo.domain.product.presentation.data.request.CreateProductRequest
import com.example.demo.domain.product.presentation.data.response.ProductResponse
import org.springframework.stereotype.Component

@Component
class ProductConverter {
    fun toDto(createProductRequest: CreateProductRequest): CreateProduct =
        CreateProduct(
            title = createProductRequest.title,
            price = createProductRequest.price,
            category = createProductRequest.category
        )

    fun toDto(productId: Long): GetProduct =
        GetProduct(
            productId = productId
        )

    fun toEntity(createProduct: CreateProduct): Product =
        Product(
            title = createProduct.title,
            price = createProduct.price,
            category = createProduct.category
        )

    fun toResponse(product: Product): ProductResponse =
        ProductResponse(
            id = product.id,
            title = product.title,
            price = product.price,
            category = product.category
        )

}