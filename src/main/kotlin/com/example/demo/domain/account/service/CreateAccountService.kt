package com.example.demo.domain.account.service

import com.example.demo.domain.account.presentation.data.dto.CreateAccount

interface CreateAccountService {
    fun execute(createAccount: CreateAccount)
}