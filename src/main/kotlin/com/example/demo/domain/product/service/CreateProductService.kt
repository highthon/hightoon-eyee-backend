package com.example.demo.domain.product.service

import com.example.demo.domain.product.presentation.data.dto.CreateProduct

interface CreateProductService {
    fun execute(createProduct: CreateProduct)
}