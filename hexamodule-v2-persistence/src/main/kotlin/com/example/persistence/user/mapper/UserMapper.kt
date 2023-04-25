package com.example.persistence.user.mapper

import com.example.domain.user.model.User
import com.example.persistence.user.entity.UserJpaEntity

fun UserJpaEntity.toDomain(): User =
    User(
        id = id,
        name = name,
        email = email,
        password = password,
        roles  = roles
    )

fun User.toEntity(): UserJpaEntity =
    UserJpaEntity(
        id = id,
        email = email,
        name = name,
        password = password,
        roles = roles
    )