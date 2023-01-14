package com.example.demo.domain.account.presentation.data.request

import com.fasterxml.jackson.databind.BeanDescription

data class CreateAccountRequest(
    val title: String,
    val description: String
)
