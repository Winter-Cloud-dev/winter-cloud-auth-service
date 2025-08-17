package com.wintercloud.auth

import com.wintercloud.auth.config.TokenProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@EnableConfigurationProperties(TokenProperties::class)
@SpringBootApplication
class WinterCloudAuthServiceApplication

fun main(args: Array<String>) {
	runApplication<WinterCloudAuthServiceApplication>(*args)
}
