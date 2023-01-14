package com.example.demo.domain.auth.exception

import com.example.demo.global.error.ErrorCode
import com.example.demo.global.error.exception.BasicException

class BusinessException : BasicException(ErrorCode.INTERNAL_SERVER_ERROR) {
}