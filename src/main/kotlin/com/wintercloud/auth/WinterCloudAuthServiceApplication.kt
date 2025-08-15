package com.wintercloud.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WinterCloudAuthServiceApplication

fun main(args: Array<String>) {
	runApplication<WinterCloudAuthServiceApplication>(*args)
}
