package com.example.demo.domain.account.presentation

import com.example.demo.domain.account.presentation.data.request.CreateAccountRequest
import com.example.demo.domain.account.presentation.data.response.AccountListResponse
import com.example.demo.domain.account.service.CreateAccountService
import com.example.demo.domain.account.service.GetMyAccountService
import com.example.demo.domain.account.util.AccountConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("account")
class AccountController(
    private val accountConverter: AccountConverter,
    private val createAccountService: CreateAccountService,
    private val getMyAccountService: GetMyAccountService
) {

    @PostMapping
    fun createAccount(@RequestBody createAccountRequest: CreateAccountRequest): ResponseEntity<Void> =
        accountConverter.toDto(createAccountRequest)
            .let { createAccountService.execute(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping
    fun getMyAccount(): ResponseEntity<AccountListResponse> =
        getMyAccountService.execute()
            .let { ResponseEntity.ok(it) }

}