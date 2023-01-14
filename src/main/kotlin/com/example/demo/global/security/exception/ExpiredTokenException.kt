package com.example.demo.global.security.exception
import com.example.demo.global.error.ErrorCode
import com.example.demo.global.error.exception.BasicException


class ExpiredTokenException : BasicException(ErrorCode.EXPIRED_TOKEN) {
}