package com.example.global.security.principle

import com.example.domain.user.spi.QueryUserPort
import com.example.global.security.exception.InvalidTokenException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuthDetailsService(
    private val queryUserPort: QueryUserPort
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val userId = UUID.fromString(username)
        if(!queryUserPort.existsUserById(userId))
            throw InvalidTokenException
        return AuthDetails(userId)
    }
}