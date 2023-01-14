package com.example.demo.domain.user.exception

import com.example.demo.global.error.ErrorCode
import com.example.demo.global.error.exception.BasicException

class UserNotFoundException : BasicException(ErrorCode.USER_NOT_FOUND) {

}