package com.example.global.security.token

import com.example.domain.auth.model.Role
import com.example.global.exception.InternalServerErrorException
import com.example.global.security.exception.ExpiredTokenException
import com.example.global.security.exception.InvalidRoleException
import com.example.global.security.exception.InvalidTokenException
import com.example.global.security.exception.UnexpectedTokenException
import com.example.global.security.principle.AuthDetailsService
import com.example.global.security.properties.JwtProperties
import com.example.global.security.properties.SecurityProperties
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Header
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jws
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {

    fun queryAuthentication(token: String): Authentication {
        val claims = getClaims(token)

        if(claims.header[Header.JWT_TYPE] != JwtProperties.ACCESS)
            throw InvalidTokenException

        val userDetails = getDetails(claims.body)

        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }


    private fun getClaims(token: String): Jws<Claims> {
        return try{
            Jwts.parser()
                .setSigningKey(securityProperties.secretKey)
                .parseClaimsJws(token)
        } catch(e: Exception){
            when(e){
                is InvalidClaimException -> throw InvalidTokenException
                is ExpiredJwtException -> throw ExpiredTokenException
                is JwtException -> throw UnexpectedTokenException
                else -> throw InternalServerErrorException
            }
        }
    }

    private fun getDetails(body: Claims): UserDetails =
        when(body.get(JwtProperties.AUTHORITY, String::class.java)){
            Role.USER.name, Role.ADMIN.name -> authDetailsService.loadUserByUsername(body.id)
            else -> throw InvalidRoleException
        }

}