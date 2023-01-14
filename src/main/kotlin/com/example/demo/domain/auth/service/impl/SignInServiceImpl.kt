package com.example.demo.domain.auth.service.impl

import com.example.demo.domain.auth.exception.PasswordMismatchException
import com.example.demo.domain.auth.presentation.data.dto.SignIn
import com.example.demo.domain.auth.presentation.data.response.RefreshTokenResponse
import com.example.demo.domain.auth.service.SigninService
import com.example.demo.domain.auth.util.AuthConverter
import com.example.demo.domain.user.domain.entity.User
import com.example.demo.domain.user.domain.repository.UserRepository
import com.example.demo.domain.user.exception.UserNotFoundException
import com.example.demo.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class SignInServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authConverter: AuthConverter
) : SigninService {
    override fun execute(signIn: SignIn): RefreshTokenResponse {
        if (!userRepository.existsByEmail(signIn.email)) {
            throw UserNotFoundException()
        }

        val user: User = userRepository.findByEmail(signIn.email) ?: throw UserNotFoundException()
        if (!passwordEncoder.matches(signIn.password, user.password)) {
            throw PasswordMismatchException()
        }
        val accessToken: String = jwtTokenProvider.generateAccessToken(user.email)
        val refreshToken: String = jwtTokenProvider.generateRefreshToken(user.email)
        val expiredAt: ZonedDateTime = jwtTokenProvider.accessExpiredTime

        val afterUser: User = user.updateRefresh(refreshToken)
        userRepository.save(afterUser)

        return authConverter.toResponse(accessToken, refreshToken, expiredAt)

    }
}