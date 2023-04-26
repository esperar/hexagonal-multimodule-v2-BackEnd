package com.example.persistence.auth.entity

import com.example.domain.auth.model.Role
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.UUID

@RedisHash("refresh_token")
data class RefreshTokenEntity(

    @Id
    val token: String,

    val userId: UUID,

    val role: Role,

    @TimeToLive
    val expirationTime: Int

)