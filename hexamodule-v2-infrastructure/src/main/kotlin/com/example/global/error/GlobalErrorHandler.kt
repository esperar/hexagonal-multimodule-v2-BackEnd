package com.example.global.error

import com.example.global.error.ErrorResponse
import com.example.global.error.ValidationErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.net.BindException

@RestControllerAdvice
class GlobalErrorHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException::class)
    protected fun handleBindException(e: BindingResult): ValidationErrorResponse? = ErrorResponse.of(e)
}