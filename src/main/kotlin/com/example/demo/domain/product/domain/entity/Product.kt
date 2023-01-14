package com.example.demo.domain.product.domain.entity

import javax.persistence.*

@Table
@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    val title: String,
    val price: String
)