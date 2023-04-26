package com.example.persistence.auth.mapper

import com.example.domain.auth.model.RefreshToken
import com.example.persistence.GenericMapper
import com.example.persistence.auth.entity.RefreshTokenEntity
import org.springframework.stereotype.Component

@Component
class RefreshTokenMapper() : GenericMapper<RefreshToken, RefreshTokenEntity> {

    override fun toDomain(entity: RefreshTokenEntity?): RefreshToken? {
        return entity?.let {
            RefreshToken(
                token = it.token,
                userId = it.userId,
                role = it.role,
                expirationTime = it.expirationTime
            )
        }
    }

    override fun toEntity(domain: RefreshToken): RefreshTokenEntity {
        return RefreshTokenEntity(
            token = domain.token,
            userId = domain.userId,
            role = domain.role,
            expirationTime = domain.expirationTime
        )
    }
}