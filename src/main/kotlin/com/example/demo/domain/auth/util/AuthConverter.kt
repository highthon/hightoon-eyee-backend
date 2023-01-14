package com.example.demo.domain.auth.util

import com.example.demo.domain.auth.presentation.data.dto.RefreshToken
import com.example.demo.domain.auth.presentation.data.dto.SignIn
import com.example.demo.domain.auth.presentation.data.dto.Signup
import com.example.demo.domain.auth.presentation.data.request.SignInRequest
import com.example.demo.domain.auth.presentation.data.request.SignupRequest
import com.example.demo.domain.auth.presentation.data.response.RefreshTokenResponse
import com.example.demo.domain.user.domain.entity.User
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
class AuthConverter {
    fun toDto(signupRequest: SignupRequest): Signup =
        Signup(
            email = signupRequest.email,
            password = signupRequest.password,
            name = signupRequest.name
        )

    fun toDto(signInRequest: SignInRequest): SignIn =
        SignIn(
            email = signInRequest.email,
            password = signInRequest.password
        )

    fun toDto(refreshToken: String): RefreshToken =
        RefreshToken(
            refreshToken = refreshToken
        )

    fun toResponse(accessToken: String, refreshToken: String, expiredTime: ZonedDateTime): RefreshTokenResponse =
        RefreshTokenResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
            expiredAt = expiredTime
        )

    fun toEntity(signup: Signup, encodePassword: String): User =
        User(
            email = signup.email,
            password = encodePassword,
            name = signup.name,
            image_url = ""
        )

    fun toEntity(signup: Signup, encodePassword: String, imageUrl: String): User =
        User(
            email = signup.email,
            password = encodePassword,
            name = signup.name,
            image_url = "https://hehe-s3.s3.ap-northeast-2.amazonaws.com/$imageUrl"
        )

}