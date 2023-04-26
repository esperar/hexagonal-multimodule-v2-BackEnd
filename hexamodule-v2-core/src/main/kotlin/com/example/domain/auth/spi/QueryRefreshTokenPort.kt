package com.example.domain.auth.spi

import com.example.domain.auth.model.RefreshToken

interface QueryRefreshTokenPort {
    fun queryRefreshToken(token: String): RefreshToken?
}