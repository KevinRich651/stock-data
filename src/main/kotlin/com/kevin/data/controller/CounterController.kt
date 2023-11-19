package com.kevin.data.controller

import com.kevin.data.model.ApiResponse
import com.kevin.data.model.CounterRequest
import com.kevin.data.service.CounterService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


/**
 * counter控制器
 */
@RestController
class CounterController {
    private val logger = LoggerFactory.getLogger(CounterController::class.java)

    @Autowired
    private lateinit var counterService: CounterService

    /**
     * 获取当前计数
     * @return API response json
     */
    @GetMapping(value = ["/api/count"])
    fun get(): ApiResponse {
        logger.info("/api/count get request")
        val cnt: Int = counterService.getCount()
        return ApiResponse.ok(cnt)
    }

    /**
     * 更新计数，自增或者清零
     * @param request [CounterRequest]
     * @return API response json
     */
    @PostMapping(value = ["/api/count"])
    fun create(@RequestBody request: CounterRequest): ApiResponse {
        logger.info("/api/count post request, action: {}", request.action)
        return if (request.action.equals("inc")) {
            ApiResponse.ok(counterService.upsertCount())
        } else if (request.action.equals("clear")) {
            counterService.clearCount()
            ApiResponse.ok(0)
        } else {
            ApiResponse.error("参数action错误")
        }
    }
}