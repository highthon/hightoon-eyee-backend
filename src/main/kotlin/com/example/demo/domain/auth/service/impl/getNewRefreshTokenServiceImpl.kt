package com.example.demo.domain.auth.service.impl

import com.example.demo.domain.auth.presentation.data.dto.RefreshToken
import com.example.demo.domain.auth.presentation.data.response.RefreshTokenResponse
import com.example.demo.domain.auth.service.getNewRefreshTokenService
import com.example.demo.domain.auth.util.AuthConverter
import com.example.demo.domain.user.domain.entity.User
import com.example.demo.domain.user.domain.repository.UserRepository
import com.example.demo.domain.user.exception.UserNotFoundException
import com.example.demo.global.security.exception.InvalidTokenException
import com.example.demo.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class getNewRefreshTokenServiceImpl(
    private val jwtTokenProvider: JwtTokenProvider,
    private val userRepository: UserRepository,
    private val authConverter: AuthConverter
) : getNewRefreshTokenService {

    override fun execute(refreshToken: RefreshToken): RefreshTokenResponse {
        val refresh = jwtTokenProvider.parseToken(refreshToken.refreshToken)
            ?: throw InvalidTokenException()
        val email: String = jwtTokenProvider.exactEmailFromRefreshToken(refresh)

        val user: User = userRepository.findByEmail(email) ?: throw UserNotFoundException()

        val accessToken: String = jwtTokenProvider.generateAccessToken(email)
        val refreshToken: String = jwtTokenProvider.generateRefreshToken(email)
        val expiredAt: ZonedDateTime = jwtTokenProvider.accessExpiredTime

        val afterUser: User = user.updateRefresh(refreshToken)
        userRepository.save(afterUser)

        return authConverter.toResponse(accessToken, refreshToken, expiredAt)
    }
}