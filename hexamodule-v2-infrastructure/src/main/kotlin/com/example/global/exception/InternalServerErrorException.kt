package com.example.global.exception

import com.example.common.error.BasicException
import com.example.global.error.GlobalErrorCode

object InternalServerErrorException : BasicException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
)