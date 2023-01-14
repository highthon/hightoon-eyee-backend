package com.example.demo.domain.user.domain.entity

import javax.persistence.*

@Entity
@Table
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val email: String,
    val password: String,
    val name: String,
    val image_url: String
) {
}