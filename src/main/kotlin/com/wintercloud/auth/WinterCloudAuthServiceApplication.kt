package com.wintercloud.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class WinterCloudAuthServiceApplication

fun main(args: Array<String>) {
	runApplication<WinterCloudAuthServiceApplication>(*args)
}
