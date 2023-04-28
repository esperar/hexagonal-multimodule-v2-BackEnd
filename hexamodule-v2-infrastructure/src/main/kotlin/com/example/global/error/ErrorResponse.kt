package com.example.global.error

import com.example.common.error.ErrorProperty
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException

data class ErrorResponse(
    val status: Int,
    val message: String,
    val code: String
) {
    companion object {
        fun of(errorProperty: ErrorProperty) = ErrorResponse(
            status = errorProperty.status(),
            message = errorProperty.message(),
            code = errorProperty.code()
        )

        fun of(e: BindingResult): ValidationErrorResponse {
            val errorMap = HashMap<String, String?>()

            for (error: FieldError in e.fieldErrors) {
                errorMap[error.field] = error.defaultMessage
            }

            return ValidationErrorResponse(
                GlobalErrorCode.BAD_REQUEST.status(),
                fieldError = errorMap
            )
        }

        fun of(e: ConstraintViolationException): ValidationErrorResponse {
            val errorMap = HashMap<String, String?>()

            for (error: ConstraintViolation<*> in e.constraintViolations) {
                val errorPropertyPath = error.propertyPath.toString()

                val index = errorPropertyPath.indexOf(".")
                val errorField = errorPropertyPath.substring(index.plus(1))

                errorMap[errorField] = error.message
            }

            return ValidationErrorResponse(
                status = GlobalErrorCode.BAD_REQUEST.status(),
                fieldError = errorMap
            )
        }
    }
}

data class ValidationErrorResponse(
    val status: Int,
    val fieldError: Map<String, String?>
)
