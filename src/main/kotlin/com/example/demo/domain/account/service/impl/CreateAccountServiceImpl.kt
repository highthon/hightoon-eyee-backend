package com.example.demo.domain.account.service.impl

import com.example.demo.domain.account.domain.entity.Account
import com.example.demo.domain.account.domain.repository.AccountRepository
import com.example.demo.domain.account.presentation.data.dto.CreateAccount
import com.example.demo.domain.account.service.CreateAccountService
import com.example.demo.domain.account.util.AccountConverter
import com.example.demo.domain.user.domain.entity.User
import com.example.demo.domain.user.util.UserUtil
import org.springframework.stereotype.Service

@Service
class CreateAccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val userUtil: UserUtil,
    private val accountConverter: AccountConverter
) : CreateAccountService {

    override fun execute(createAccount: CreateAccount) {
        val user: User = userUtil.fetchCurrentUser()

        val account: Account = accountConverter.toEntity(createAccount, user)

        accountRepository.save(account)
    }

}