package com.example.demo.domain.product.presentation

import com.example.demo.domain.product.presentation.data.request.CreateProductRequest
import com.example.demo.domain.product.presentation.data.response.ProductListResponse
import com.example.demo.domain.product.presentation.data.response.ProductResponse
import com.example.demo.domain.product.service.CreateProductService
import com.example.demo.domain.product.service.GetProductService
import com.example.demo.domain.product.service.GetProductsService
import com.example.demo.domain.product.util.ProductConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class ProductController(
    private val getProductsService: GetProductsService,
    private val createProductService: CreateProductService,
    private val getProductService: GetProductService,
    private val productConverter: ProductConverter
) {

    @GetMapping
    fun getProducts(): ResponseEntity<ProductListResponse> =
        ResponseEntity.ok(getProductsService.execute())

    @PostMapping
    fun createProduct(@RequestBody createProductRequest: CreateProductRequest): ResponseEntity<Void> =
        productConverter.toDto(createProductRequest)
            .let { createProductService.execute(it) }
            .let { ResponseEntity.ok().build() }

    @GetMapping("/{product_id}")
    fun getProduct(@PathVariable("product_id") productId: Long): ResponseEntity<ProductResponse> =
        productConverter.toDto(productId)
            .let { getProductService.execute(it) }
            .let { ResponseEntity.ok(it) }

}