package com.example.persistence.user.entity

import com.example.domain.auth.model.Role
import com.example.persistence.BaseUuidEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
class UserJpaEntity(

    override val id: UUID,

    @Column(columnDefinition = "VARCHAR(255)")
    val email: String,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val password: String,

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Role", joinColumns = [JoinColumn(name = "user_id")])
    val roles: MutableList<Role> = mutableListOf()

    ): BaseUuidEntity(id) {

}