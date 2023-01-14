package com.example.demo.domain.user.domain.entity

import javax.persistence.*

@Entity
@Table
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    val email: String,
    val password: String,
    val name: String,
    val image_url: String,
    val refreshToken: String? = ""
) {
    fun updateRefresh(refreshToken: String): User {
        val user: User = User(
            email = email,
            password = password,
            name = name,
            image_url = image_url,
            refreshToken = refreshToken
        )
        user.id = this.id
        return user
    }
}