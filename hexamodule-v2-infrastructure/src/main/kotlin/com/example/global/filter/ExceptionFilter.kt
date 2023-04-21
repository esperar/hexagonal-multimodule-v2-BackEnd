package com.example.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.filter.OncePerRequestFilter

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: javax.servlet.http.HttpServletRequest,
        response: javax.servlet.http.HttpServletResponse,
        filterChain: javax.servlet.FilterChain,
    ) {
        TODO("Not yet implemented")
    }

}