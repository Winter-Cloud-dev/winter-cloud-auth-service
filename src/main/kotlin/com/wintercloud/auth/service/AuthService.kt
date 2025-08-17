package com.wintercloud.auth.service

import com.wintercloud.auth.dto.Token
import com.wintercloud.auth.feign.facade.UserFacade
import com.wintercloud.auth.util.JwtProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
    private val userFacade: UserFacade,
    private val jwtProvider: JwtProvider
) {
    @Transactional(readOnly = true)
    suspend fun login(id: String, password: String): Token {
        val userId = userFacade.getUserId(id, password)

        return jwtProvider.generateTokens(userId, "ROLE_USER")
    }
}