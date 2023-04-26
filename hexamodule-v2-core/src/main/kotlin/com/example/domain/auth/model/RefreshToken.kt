package com.example.domain.auth.model

import com.example.common.annotation.Aggregate
import java.util.UUID

@Aggregate
class RefreshToken(

    val token: String,

    val userId: UUID,

    val role: Role,

    val expirationTime: Int
)