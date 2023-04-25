package com.example.global.security.exception

import com.example.common.error.BasicException
import com.example.global.security.exception.error.SecurityErrorCode

object InvalidRoleException : BasicException (
    SecurityErrorCode.INVALID_ROLE
)