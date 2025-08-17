package com.wintercloud.auth.exception

class BusinessException(
    val errorCode: ErrorCode,
    vararg args: Any?,
) : RuntimeException()