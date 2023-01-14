package com.example.demo.domain.auth.presentation.data.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime

data class RefreshTokenResponse(
    @JsonProperty
    val accessToken: String,

    @JsonProperty
    val refreshToken: String,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val expiredAt: ZonedDateTime
)