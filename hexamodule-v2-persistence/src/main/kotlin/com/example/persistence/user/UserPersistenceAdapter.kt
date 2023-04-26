package com.example.persistence.user

import com.example.domain.user.model.User
import com.example.domain.user.spi.UserPort
import com.example.persistence.user.mapper.UserMapper
import com.example.persistence.user.repository.UserJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserPersistenceAdapter(
    private val userMapper: UserMapper,
    private val userRepository: UserJpaRepository
) : UserPort {
    override fun queryUserById(userId: UUID): User? = userMapper.toDomain(
        userRepository.findByIdOrNull(userId)
    )

    override fun existsUserById(userId: UUID): Boolean =
        userRepository.existsById(userId)


}