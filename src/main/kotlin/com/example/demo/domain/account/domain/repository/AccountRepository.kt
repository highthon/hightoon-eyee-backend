package com.example.demo.domain.account.domain.repository

import com.example.demo.domain.account.domain.entity.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long> {
}