package com.example.persistence.user.mapper

import com.example.domain.user.model.User
import com.example.persistence.GenericMapper
import com.example.persistence.user.entity.UserJpaEntity
import com.example.persistence.user.repository.UserJpaRepository
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val userJpaRepository: UserJpaRepository
) : GenericMapper<User, UserJpaEntity> {

    override fun toDomain(entity: UserJpaEntity?): User? =
        entity?.let {
            User(
                id = it.id,
                name = it.name,
                email = it.email,
                password = it.password,
                roles = it.roles
            )
        }

    override fun toEntity(domain: User): UserJpaEntity =
        domain.let {
            UserJpaEntity(
                id = it.id,
                name = it.name,
                email = it.email,
                password = it.password,
                roles = it.roles
            )
        }

}