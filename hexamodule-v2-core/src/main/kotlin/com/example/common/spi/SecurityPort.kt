package com.example.common.spi

import java.util.UUID

interface SecurityPort {

    fun isPasswordMatch(rawPassword: String, encodedPassword: String): Boolean

    fun queryCurrentUserId(): UUID

    fun encodedPassword(password: String): String
}