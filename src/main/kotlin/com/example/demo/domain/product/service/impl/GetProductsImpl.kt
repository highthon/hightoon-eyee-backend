package com.example.demo.domain.product.service.impl

import com.example.demo.domain.product.domain.repository.ProductRepository
import com.example.demo.domain.product.presentation.data.response.ProductListResponse
import com.example.demo.domain.product.presentation.data.response.ProductResponse
import com.example.demo.domain.product.service.GetProducts
import org.springframework.stereotype.Service

@Service
class GetProductsImpl(
    private val productRepository: ProductRepository
) : GetProducts {
    override fun execute(): ProductListResponse =
        ProductListResponse(
            products = productRepository.findAll()
                .map { ProductResponse(it) }
        )
}