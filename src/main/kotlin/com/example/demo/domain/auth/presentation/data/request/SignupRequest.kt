package com.example.demo.domain.auth.presentation.data.request

data class SignupRequest(
    val email: String,
    val password: String,
    val name: String
)