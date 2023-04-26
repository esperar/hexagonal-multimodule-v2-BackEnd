package com.example.global.security.token

import com.example.domain.auth.dto.TokenResponse
import com.example.domain.auth.model.Role
import com.example.domain.auth.spi.JwtPort
import com.example.global.security.properties.SecurityProperties
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateJwtAdapter(
    private val securityProperties: SecurityProperties,
    private val commandRefreshTokenPort: CommandRefreshTokenPort
) : JwtPort {

    override fun receiveToken(userId: UUID, role: Role): TokenResponse {
        TODO("Not yet implemented")
    }

    private fun generateAccessToken(userId: UUID, role: Role) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperte)
}