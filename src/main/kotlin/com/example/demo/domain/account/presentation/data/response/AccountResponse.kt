package com.example.demo.domain.account.presentation.data.response

import com.example.demo.domain.account.domain.entity.Account
import com.example.demo.domain.user.domain.entity.User

class AccountResponse(
    val id: Long,
    val title: String,
    val description: String,
    val category: String
) {
    constructor(account: Account) : this(
        id = account.id,
        title = account.title,
        description = account.description,
        category = account.category
    )
}
