package com.example.demo.domain.product.service

import com.example.demo.domain.product.presentation.data.dto.GetProduct
import com.example.demo.domain.product.presentation.data.response.ProductResponse

interface GetProductService {
    fun execute(getProduct: GetProduct): ProductResponse
}