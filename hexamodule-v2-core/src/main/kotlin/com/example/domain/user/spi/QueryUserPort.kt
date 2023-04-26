package com.example.domain.user.spi

import com.example.domain.user.model.User
import java.util.UUID

interface QueryUserPort {

    fun queryUserById(userId: UUID): User?
    fun existsUserById(userId: UUID): Boolean
}