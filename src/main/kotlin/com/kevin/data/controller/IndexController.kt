package com.kevin.data.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class IndexController {
    /**
     * 主页页面
     * @return API response html
     */
    @GetMapping
    fun index(): String {
        return "index"
    }
}
