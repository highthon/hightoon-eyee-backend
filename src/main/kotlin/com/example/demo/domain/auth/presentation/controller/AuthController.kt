package com.example.demo.domain.auth.presentation.controller

import com.example.demo.domain.auth.presentation.data.request.SignInRequest
import com.example.demo.domain.auth.presentation.data.request.SignupRequest
import com.example.demo.domain.auth.presentation.data.response.RefreshTokenResponse
import com.example.demo.domain.auth.service.SigninService
import com.example.demo.domain.auth.service.SignupService
import com.example.demo.domain.auth.service.getNewRefreshTokenService
import com.example.demo.domain.auth.util.AuthConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController(
    private val signupService: SignupService,
    private val signinService: SigninService,
    private val getNewRefreshTokenService: getNewRefreshTokenService,
    private val authConverter: AuthConverter
) {

    @PostMapping("signup")
    fun signup(
        @RequestPart(value = "files", required = false) multipartFile: MultipartFile?,
        @Valid @RequestPart(value = "signupRequest") signupRequest: SignupRequest
    ): ResponseEntity<Void> =
        authConverter.toDto(signupRequest)
            .let { signupService.execute(it, multipartFile) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PostMapping
    fun signIn(@RequestBody signInRequest: SignInRequest): ResponseEntity<RefreshTokenResponse> =
        authConverter.toDto(signInRequest)
            .let { signinService.execute(it) }
            .let { ResponseEntity.ok(it) }


    @PatchMapping
    fun getNewRefreshToken(@RequestHeader("RefreshToken") refreshToken: String): ResponseEntity<RefreshTokenResponse> =
        authConverter.toDto(refreshToken)
            .let { getNewRefreshTokenService.execute(it) }
            .let { ResponseEntity.ok(it) }

}