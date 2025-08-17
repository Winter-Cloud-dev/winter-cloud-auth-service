package com.wintercloud.auth.feign.facade

import com.wintercloud.auth.exception.BusinessException
import com.wintercloud.auth.exception.ErrorCode
import com.wintercloud.auth.feign.client.UserClient
import feign.FeignException
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserFacade(
    private val userClient: UserClient,
) {
    suspend fun getUserId(email: String, password: String): UUID {
        return try {
            userClient.getUserId(email, password).userId
        } catch (fe: FeignException) {
            when (fe.status()) {
                404 -> throw BusinessException(ErrorCode.USER_NOT_FOUND)
                401 -> throw BusinessException(ErrorCode.INVALID_PASSWORD)
                else -> {
                    fe.printStackTrace()
                    throw BusinessException(ErrorCode.INVALID_ERROR_CODE)
                }
            }
        }
    }
}