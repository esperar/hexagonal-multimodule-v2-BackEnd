package com.example.global.security.exception

import com.example.common.error.BasicException
import com.example.global.security.exception.error.SecurityErrorCode

object ForbiddenException : BasicException(
    SecurityErrorCode.FORBIDDEN
)