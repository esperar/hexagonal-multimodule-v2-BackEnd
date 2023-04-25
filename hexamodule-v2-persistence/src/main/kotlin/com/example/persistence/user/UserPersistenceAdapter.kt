package com.example.persistence.user

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userMapper: UserMapper
) {
}