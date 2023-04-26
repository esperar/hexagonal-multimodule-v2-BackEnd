package com.example.global.security.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.*

@ConfigurationProperties(prefix = "secret")
@ConstructorBinding
class SecurityProperties(
    secretKey: String,
    val accessExp: Int,
    val refreshExp: Int
) {

    val secretKey: String = Base64.getEncoder().encodeToString(secretKey.toByteArray())
}