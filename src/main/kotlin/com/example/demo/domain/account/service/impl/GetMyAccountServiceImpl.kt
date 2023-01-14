package com.example.demo.domain.account.service.impl

import com.example.demo.domain.account.domain.repository.AccountRepository
import com.example.demo.domain.account.presentation.data.response.AccountListResponse
import com.example.demo.domain.account.presentation.data.response.AccountResponse
import com.example.demo.domain.account.service.GetMyAccountService
import com.example.demo.domain.user.domain.entity.User
import com.example.demo.domain.user.util.UserUtil
import org.springframework.stereotype.Service

@Service
class GetMyAccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val userUtil: UserUtil
) : GetMyAccountService {

    override fun execute(): AccountListResponse {
        val user: User = userUtil.fetchCurrentUser()

        return AccountListResponse(
            accounts = accountRepository.findByUser(user)
                .map { AccountResponse(it) }
        )
    }

}