package com.kevin.data

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages =  ["com.kevin.data"])
class WxCloudApplication
fun main() {
    SpringApplication.run(WxCloudApplication::class.java)
}
