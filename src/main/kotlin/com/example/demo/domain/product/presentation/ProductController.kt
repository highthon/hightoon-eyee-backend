package com.example.demo.domain.product.presentation

import com.example.demo.domain.product.presentation.data.response.ProductListResponse
import com.example.demo.domain.product.service.GetProducts
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("product")
class ProductController(
    private val getProducts: GetProducts
) {

    @GetMapping
    fun getProducts(): ResponseEntity<ProductListResponse> =
        ResponseEntity.ok(getProducts.execute())

}