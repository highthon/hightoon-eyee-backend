package com.example.demo.domain.auth.service

import com.example.demo.domain.auth.presentation.data.dto.Signup
import org.springframework.web.multipart.MultipartFile

interface SignupService {
    fun execute(signup: Signup, multipartFile: MultipartFile?)
}