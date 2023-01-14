package com.example.demo.domain.account.util

import com.example.demo.domain.account.domain.entity.Account
import com.example.demo.domain.account.presentation.data.dto.CreateAccount
import com.example.demo.domain.account.presentation.data.request.CreateAccountRequest
import com.example.demo.domain.user.domain.entity.User
import org.springframework.stereotype.Component

@Component
class AccountConverter {
    fun toDto(createAccountRequest: CreateAccountRequest): CreateAccount =
        CreateAccount(
            title = createAccountRequest.title,
            description = createAccountRequest.description
        )

    fun toEntity(createAccount: CreateAccount, user: User): Account =
        Account(
            title = createAccount.title,
            description = createAccount.description,
            user = user
        )
}