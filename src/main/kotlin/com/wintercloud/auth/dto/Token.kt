package com.wintercloud.auth.dto

data class Token(
    val grantType: String,
    val accessToken: String,
    val refreshToken: String,
)