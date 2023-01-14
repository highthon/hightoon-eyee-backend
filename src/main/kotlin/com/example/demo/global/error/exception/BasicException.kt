package com.example.demo.global.error.exception

import com.example.demo.global.error.ErrorCode

open class BasicException(val errorCode: ErrorCode) : RuntimeException() {
}