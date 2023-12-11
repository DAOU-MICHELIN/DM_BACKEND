package com.michelinguide.daou.common.handler;

import com.michelinguide.daou.common.code.ApiResponseCode;
import com.michelinguide.daou.common.dto.ApiResponse;
import com.michelinguide.daou.common.handler.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiResponse> unauthorizedHandler(UnauthorizedException e) {

        ApiResponseCode apiResponseCode = e.getApiResponseCode();
        log.error("code : {} message: {}", apiResponseCode.getCode(), apiResponseCode.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                             .body(ApiResponse.fail(apiResponseCode));
    }
