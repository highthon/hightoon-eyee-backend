package com.example.demo.domain.product.service.impl

import com.example.demo.domain.product.domain.repository.ProductRepository
import com.example.demo.domain.product.presentation.data.dto.CreateProduct
import com.example.demo.domain.product.service.CreateProductService
import com.example.demo.domain.product.util.ProductConverter
import org.springframework.stereotype.Service

@Service
class CreateProductServiceImpl(
    private val productRepository: ProductRepository,
    private val productConverter: ProductConverter
) : CreateProductService {
    override fun execute(createProduct: CreateProduct) {
        val product = productConverter.toEntity(createProduct)
        productRepository.save(product)
    }

}