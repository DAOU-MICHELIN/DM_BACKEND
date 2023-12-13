package com.michelinguide.daou.common.handler.exception;

import com.michelinguide.daou.common.code.ApiResponseCode;
import lombok.Getter;

@Getter
public class CustomException extends  RuntimeException {

    private ApiResponseCode apiResponseCode;

    private CustomException(ApiResponseCode  apiResponseCode){
        this.apiResponseCode = apiResponseCode;
    }
    public static CustomException duplicateEmailException() {
        return new CustomException(ApiResponseCode.DUPLICATE_EMAIL);
    }
}
