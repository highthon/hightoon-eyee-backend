package com.example.demo.domain.product.domain.repository

import com.example.demo.domain.product.domain.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
}