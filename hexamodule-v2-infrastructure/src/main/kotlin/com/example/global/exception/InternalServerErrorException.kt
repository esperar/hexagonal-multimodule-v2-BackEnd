package com.example.global.exception

import com.example.global.error.GlobalErrorCode
import common.error.BasicException

object InternalServerErrorException : BasicException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
)