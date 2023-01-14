package com.example.demo.domain.account.service

import com.example.demo.domain.account.presentation.data.response.AccountListResponse

interface GetMyAccountService {
    fun execute(): AccountListResponse
}