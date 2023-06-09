package com.example.common.error

abstract class BasicException(
    val errorProperty: ErrorProperty
) : RuntimeException() {
    override fun fillInStackTrace(): Throwable = this
}