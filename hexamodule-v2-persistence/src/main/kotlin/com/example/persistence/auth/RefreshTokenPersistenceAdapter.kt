package com.example.persistence.auth

import com.example.domain.auth.model.RefreshToken
import com.example.domain.auth.spi.RefreshTokenPort
import com.example.persistence.auth.mapper.RefreshTokenMapper
import com.example.persistence.auth.repository.RefreshTokenRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper
) : RefreshTokenPort {

    override fun save(refreshToken: RefreshToken): RefreshToken =
        refreshTokenMapper.toDomain(refreshTokenRepository.save(
            refreshTokenMapper.toEntity(refreshToken)
        ))!!

    override fun queryRefreshToken(token: String): RefreshToken? =
        refreshTokenMapper.toDomain(refreshTokenRepository.findByIdOrNull(token))
}