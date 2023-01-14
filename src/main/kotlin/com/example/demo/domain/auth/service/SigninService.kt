package com.example.demo.domain.auth.service

import com.example.demo.domain.auth.presentation.data.dto.SignIn
import com.example.demo.domain.auth.presentation.data.response.RefreshTokenResponse

interface SigninService {
    fun execute(signIn: SignIn): RefreshTokenResponse
}