package com.example.global.error

import com.example.common.error.ErrorProperty

enum class GlobalErrorCode(
    private val status: Int,
    private val message: String,
    private val sequence: Int
) : ErrorProperty {

    BAD_REQUEST(400, "Bad Request", 1),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", 1);

    override fun status(): Int = status
    override fun message(): String = message
    override fun code(): String = "GLOBAL-$status-$sequence"
}