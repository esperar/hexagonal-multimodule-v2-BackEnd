package com.example.global.filter

import com.example.global.error.ErrorResponse
import com.example.global.exception.InternalServerErrorException
import com.fasterxml.jackson.databind.ObjectMapper
import common.error.BasicException
import common.error.ErrorProperty
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    private val log by lazy { LoggerFactory.getLogger(this.javaClass.simpleName) }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: javax.servlet.FilterChain,
    ) {

        try{
            filterChain.doFilter(request, response)
        } catch(e: BasicException){
            when(e.cause) {
                is BasicException -> {
                    errorToJson((e.cause as BasicException).errorProperty, response)
                    log.error(e.message)
                }
                else -> {
                    errorToJson(InternalServerErrorException.errorProperty, response)
                    log.error(InternalServerErrorException.message)
                }
            }
        }
    }

    private fun errorToJson(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.status = errorProperty.status()
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(ErrorResponse.of(errorProperty)))
    }

}