package com.example.demo.domain.product.service.impl

import com.example.demo.domain.product.domain.repository.ProductRepository
import com.example.demo.domain.product.presentation.data.response.ProductListResponse
import com.example.demo.domain.product.presentation.data.response.ProductResponse
import com.example.demo.domain.product.service.GetProductsService
import org.springframework.stereotype.Service

@Service
class GetProductsServiceImpl(
    private val productRepository: ProductRepository
) : GetProductsService {
    override fun execute(): ProductListResponse =
        ProductListResponse(
            products = productRepository.findAll()
                .map { ProductResponse(it) }
        )
}