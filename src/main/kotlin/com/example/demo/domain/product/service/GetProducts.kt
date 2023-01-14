package com.example.demo.domain.product.service

import com.example.demo.domain.product.presentation.data.response.ProductListResponse

interface GetProducts {
    fun execute(): ProductListResponse
}