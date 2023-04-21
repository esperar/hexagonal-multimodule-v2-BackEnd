package com.example.global.error

import common.error.ErrorProperty
import org.springframework.validation.BindingResult

data class ErrorResponse(
    val status: Int,
    val message: String
) {
    companion object {
        fun of(errorProperty: ErrorProperty) = ErrorResponse(
            status = errorProperty.status(),
            message = errorProperty.message()
        )

        fun of(e: BindingResult): ValidationErrorResponse {
            val errorMap = e.fieldErrors.associate { it.field to it.defaultMessage }

            return ValidationErrorResponse(
                GlobalErrorCode.BAD_REQUEST.status(),
                fieldError = errorMap
            )
        }
    }
}

data class ValidationErrorResponse(
    val status: Int,
    val fieldError: Map<String, String?>
)
