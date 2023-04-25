package com.example.domain.user.model

import com.example.common.annotation.Aggregate
import com.example.domain.auth.model.Role
import java.util.UUID

@Aggregate
data class User(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val email: String,
    val roles: MutableList<Role>
)
