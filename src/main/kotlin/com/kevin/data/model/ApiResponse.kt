package com.kevin.data.model

import java.util.HashMap

data class ApiResponse<T>(val code: Int, val errorMsg: String? = null, val data: T? = null) {
    companion object {
        fun ok(): ApiResponse<Any> {
            return ApiResponse(code = 0, errorMsg = "")
        }

        fun <T> ok(data: T): ApiResponse<T> {
            return ApiResponse(code = 0, data = data)
        }

        fun error(errorMsg: String): ApiResponse<Any> {
            return ApiResponse(code = 0, errorMsg = errorMsg)
        }
    }
}

