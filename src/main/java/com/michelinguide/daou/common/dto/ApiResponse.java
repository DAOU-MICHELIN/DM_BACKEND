package com.michelinguide.daou.common.dto;

import com.michelinguide.daou.common.code.ApiResponseCode;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

    private String code;
    private String message;
    private T data;

    private ApiResponse(ApiResponseCode apiResponseCode, T data) {

        this.code = apiResponseCode.getCode();
        this.message = apiResponseCode.getMessage();
        this.data = data;
    }

    public static <T> ApiResponse<T> changeSuccess(ApiResponseCode apiResponseCode, T data) {

        return new ApiResponse(apiResponseCode, data);
    }

    public static ApiResponse readSuccess() {

        return new ApiResponse(ApiResponseCode.READ_SUCCESS, "");
    }

    public static  ApiResponse fail(ApiResponseCode apiResponseCode){

        return new ApiResponse(apiResponseCode, "");
    }
}
