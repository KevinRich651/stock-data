package com.kevin.data.model

import java.util.HashMap

class ApiResponse private constructor(private val code: Int, private val errorMsg: String, private val data: Any) {
    companion object {
        fun ok(): ApiResponse {
            return ApiResponse(0, "", HashMap<Any, Any>())
        }

        fun ok(data: Any): ApiResponse {
            return ApiResponse(0, "", data)
        }

        fun error(errorMsg: String): ApiResponse {
            return ApiResponse(0, errorMsg, HashMap<Any, Any>())
        }
    }
}

