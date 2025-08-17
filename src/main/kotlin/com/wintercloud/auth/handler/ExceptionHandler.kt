package com.wintercloud.auth.handler

import com.wintercloud.auth.converter.MessageConverter
import com.wintercloud.auth.dto.ErrorResponse
import com.wintercloud.auth.exception.BusinessException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler(
    private val messageConverter: MessageConverter,
) {
    private val logger = KotlinLogging.logger { }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<ErrorResponse> {
        val errorCode = e.errorCode
        val code = errorCode.code
        val body = ErrorResponse(
            code = code,
            message = messageConverter.getMessage(code),
        )
        logger.error { "Business Exception: $errorCode" }
        return ResponseEntity.status(errorCode.status).body(body)
    }
}