package com.example.demo.domain.account.presentation.data.dto

import com.fasterxml.jackson.databind.BeanDescription

data class CreateAccount(
    val title: String,
    val description: String
)