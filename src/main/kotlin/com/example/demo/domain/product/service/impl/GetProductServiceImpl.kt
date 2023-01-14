package com.example.demo.domain.product.service.impl

import com.example.demo.domain.product.domain.repository.ProductRepository
import com.example.demo.domain.product.presentation.data.dto.GetProduct
import com.example.demo.domain.product.presentation.data.response.ProductResponse
import com.example.demo.domain.product.service.GetProductService
import com.example.demo.domain.product.util.ProductConverter
import org.springframework.stereotype.Service

@Service
class GetProductServiceImpl(
    private val productConverter: ProductConverter,
    private val productRepository: ProductRepository
) : GetProductService {
    override fun execute(getProduct: GetProduct): ProductResponse =
        productRepository.findProductById(getProduct.productId)
            .let { productConverter.toResponse(it) }

}