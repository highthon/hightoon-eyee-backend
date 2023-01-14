package com.example.demo.global.error

enum class ErrorCode(
    val code: Int,
    val msg: String
) {
    PASSWORD_MISMATCH(400, "비밀번호가 일치하지 않습니다."),
    UNAUTHORIZED(401, "인증되지 않았습니다"),
    EXPIRED_TOKEN(401, "만료된 토큰입니다"),

    USER_NOT_FOUND(404, "존재하지 않는 유저입니다"),

    USER_ALREADY(409, "이미 가입된 이메일입니다"),


    INTERNAL_SERVER_ERROR(500, "알지못하는 에러입니다"),
}