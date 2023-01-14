package com.example.demo.domain.auth.service.impl

import com.example.demo.domain.auth.presentation.data.dto.Signup
import com.example.demo.domain.auth.service.SignupService
import com.example.demo.domain.auth.util.AuthConverter
import com.example.demo.domain.auth.util.S3Util
import com.example.demo.domain.user.domain.entity.User
import com.example.demo.domain.user.domain.repository.UserRepository
import com.example.demo.domain.user.exception.UserAlreadyException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class SignupServiceImpl(
    private val userRepository: UserRepository,
    private val authConverter: AuthConverter,
    private val passwordEncoder: PasswordEncoder,
    private val s3Util: S3Util
) : SignupService {
    override fun execute(signup: Signup, multipartFile: MultipartFile?) {

        if (userRepository.existsByEmail(signup.email)) {
            throw UserAlreadyException()
        }

        if (multipartFile == null) {
            val user: User = authConverter.toEntity(signup, passwordEncoder.encode(signup.password))
            userRepository.save(user)
        } else {
            val imageUrl: String = s3Util.fileUpload(multipartFile)

            val user: User = authConverter.toEntity(signup, passwordEncoder.encode(signup.password), imageUrl)
            userRepository.save(user)
        }
    }

}