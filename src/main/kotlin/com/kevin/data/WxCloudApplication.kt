package com.kevin.data

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.kevin.data"])
open class WxCloudApplication

fun main(args: Array<String>) {
    runApplication<WxCloudApplication>(*args)
}
