package com.example.demo.global.security.exception

import com.example.demo.global.error.ErrorCode
import com.example.demo.global.error.exception.BasicException

class InvalidTokenException : BasicException(ErrorCode.UNAUTHORIZED) {
}