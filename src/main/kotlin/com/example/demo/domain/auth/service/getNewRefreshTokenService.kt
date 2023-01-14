package com.example.demo.domain.auth.service

import com.example.demo.domain.auth.presentation.data.dto.RefreshToken
import com.example.demo.domain.auth.presentation.data.response.RefreshTokenResponse

interface getNewRefreshTokenService {
    fun execute(refreshToken: RefreshToken): RefreshTokenResponse
}