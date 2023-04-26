package com.example.domain.auth.spi

import com.example.domain.auth.model.RefreshToken

interface CommandRefreshTokenPort {
    fun save(refreshToken: RefreshToken): RefreshToken
}