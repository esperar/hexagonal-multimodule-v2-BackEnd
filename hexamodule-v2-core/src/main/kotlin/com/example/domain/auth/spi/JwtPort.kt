package com.example.domain.auth.spi

import com.example.domain.auth.dto.TokenResponse
import com.example.domain.auth.model.Role
import java.util.UUID

interface JwtPort {
    fun receiveToken(userId: UUID, role: Role): TokenResponse
}