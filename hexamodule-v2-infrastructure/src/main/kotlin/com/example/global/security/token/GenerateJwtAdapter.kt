package com.example.global.security.token

import com.example.domain.auth.dto.TokenResponse
import com.example.domain.auth.model.RefreshToken
import com.example.domain.auth.model.Role
import com.example.domain.auth.spi.CommandRefreshTokenPort
import com.example.domain.auth.spi.JwtPort
import com.example.global.security.properties.JwtProperties
import com.example.global.security.properties.SecurityProperties
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class GenerateJwtAdapter(
    private val securityProperties: SecurityProperties,
    private val commandRefreshTokenPort: CommandRefreshTokenPort
) : JwtPort {

    override fun receiveToken(userId: UUID, role: Role): TokenResponse = TokenResponse(
        accessToken = generateAccessToken(userId, role),
        accessExpiredAt = LocalDateTime.now().withNano(0).plusSeconds(securityProperties.accessExp.toLong()),
        refreshToken = generateRefreshToken(userId, role),
        refreshExpiredAt = LocalDateTime.now().withNano(0).plusSeconds(securityProperties.refreshExp.toLong())
    )

    private fun generateAccessToken(userId: UUID, role: Role) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.secretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtProperties.ACCESS)
            .setId(userId.toString())
            .claim(JwtProperties.AUTHORITY, role.name)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
            .compact()

    private fun generateRefreshToken(userId: UUID, role: Role): String {
        val token = Jwts.builder()
            .signWith(SignatureAlgorithm.HS512, securityProperties.secretKey)
            .setHeaderParam(Header.JWT_TYPE, JwtProperties.REFRESH)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.refreshExp * 1000))
            .compact()

        val refreshToken = RefreshToken(
            token = token,
            userId = userId,
            role = role,
            expirationTime = securityProperties.refreshExp
        )
        commandRefreshTokenPort.save(refreshToken)

        return token
    }
}