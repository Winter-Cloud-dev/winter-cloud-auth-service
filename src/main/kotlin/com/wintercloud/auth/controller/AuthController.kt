package com.wintercloud.auth.controller

import com.wintercloud.auth.dto.LoginRequest
import com.wintercloud.auth.dto.Token
import com.wintercloud.auth.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    private val authService: AuthService,
) {

    @PostMapping("/login")
    suspend fun login(
        @RequestBody request: LoginRequest,
    ): ResponseEntity<Token> {
        return ResponseEntity.ok(
            authService.login(
                id = request.email,
                password = request.password
            )
        )
    }
}