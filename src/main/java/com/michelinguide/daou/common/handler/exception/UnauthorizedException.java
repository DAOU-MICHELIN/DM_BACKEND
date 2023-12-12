package com.michelinguide.daou.common.handler.exception;

import com.michelinguide.daou.common.code.ApiResponseCode;
import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {

    private ApiResponseCode apiResponseCode;

    public UnauthorizedException(ApiResponseCode apiResponseCode) {

        this.apiResponseCode = apiResponseCode;
    }
}
