package com.example.global.security

import com.example.common.spi.SecurityPort
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.*

@Component
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder
) : SecurityPort {

    override fun isPasswordMatch(rawPassword: String, encodedPassword: String): Boolean =
        passwordEncoder.matches(rawPassword, encodedPassword)

    override fun queryCurrentUserId(): UUID =
        UUID.fromString(SecurityContextHolder.getContext().authentication.name)

    override fun encodedPassword(password: String): String =
        passwordEncoder.encode(password)


}