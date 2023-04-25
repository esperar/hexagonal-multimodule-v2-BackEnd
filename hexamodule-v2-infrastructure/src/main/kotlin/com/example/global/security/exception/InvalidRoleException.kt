package com.example.global.security.exception

import com.example.common.error.BasicException
import com.example.global.security.exception.error.SecurityErrorCode
import com.example.global.security.properties.SecurityProperties

class InvalidRoleException : BasicException (
    SecurityErrorCode.INVALID_ROLE
)