package com.example.demo.domain.account.domain.repository

import com.example.demo.domain.account.domain.entity.Account
import com.example.demo.domain.user.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {
    fun findByUser(user: User): List<Account>
}