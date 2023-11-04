package com.kevin.data.controller;

import com.kevin.data.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kevin.data.config.ApiResponse;
import com.kevin.data.dto.CounterRequest;
import com.kevin.data.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * counter控制器
 */
@RestController
public class CounterController {
  private Logger logger = LoggerFactory.getLogger(CounterController.class);

  @Autowired
  private CounterService counterService;

  /**
   * 获取当前计数
   * @return API response json
   */
  @GetMapping(value = "/api/count")
  ApiResponse get() {
    logger.info("/api/count get request");
    int cnt = counterService.getCounter();
    return ApiResponse.ok(cnt);
  }


  /**
   * 更新计数，自增或者清零
   * @param request {@link CounterRequest}
   * @return API response json
   */
  @PostMapping(value = "/api/count")
  ApiResponse create(@RequestBody CounterRequest request) {
    logger.info("/api/count post request, action: {}", request.getAction());
    if (request.getAction().equals("inc")) {
      return ApiResponse.ok(counterService.upsertCount());
    } else if (request.getAction().equals("clear")) {
      counterService.clearCount();
      return ApiResponse.ok(0);
    } else {
      return ApiResponse.error("参数action错误");
    }
  }
}