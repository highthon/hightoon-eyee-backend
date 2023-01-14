package com.example.demo.domain.account.presentation.data.request


data class CreateAccountRequest(
    val title: String,
    val description: String,
    val category: String
)
