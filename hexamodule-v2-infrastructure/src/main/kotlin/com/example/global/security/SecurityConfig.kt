package com.example.global.security

import com.example.global.config.FilterConfig
import com.example.global.security.handler.CustomAccessDeniedHandler
import com.example.global.security.handler.CustomAuthenticationEntryPoint
import com.example.global.security.token.JwtParser
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val jwtParser: JwtParser,
    private val objectMapper: ObjectMapper,
    private val customAuthenticationEntryPoint: CustomAuthenticationEntryPoint,
    private val customAccessDeniedHandler: CustomAccessDeniedHandler
) {

    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .cors().and()

        http
            .sessionManagement()
            .sessionCreationPolicy((SessionCreationPolicy.STATELESS))
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/").permitAll()
            .anyRequest().denyAll()

        http
            .apply(FilterConfig(jwtParser, objectMapper))
        http.exceptionHandling()
            .authenticationEntryPoint(customAuthenticationEntryPoint)
            .accessDeniedHandler(customAccessDeniedHandler)

        return http.build()
    }
}