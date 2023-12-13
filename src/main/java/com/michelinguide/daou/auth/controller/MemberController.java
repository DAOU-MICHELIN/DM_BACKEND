package com.michelinguide.daou.auth.controller;

import com.michelinguide.daou.auth.dtos.EmailDto;
import com.michelinguide.daou.auth.dtos.MemberDto;
import com.michelinguide.daou.auth.service.MemberService;
import com.michelinguide.daou.common.code.ApiResponseCode;
import com.michelinguide.daou.common.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    @PostMapping("/join")
    ResponseEntity<ApiResponse> join(@RequestBody MemberDto.JoinRequest request){
        Long savedId = memberService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.changeSuccess(ApiResponseCode.CREATE_SUCCESS, savedId));
    }
    @PostMapping("/confirm-email")
    ResponseEntity<ApiResponse> confirmEmail(@Validated @RequestBody EmailDto.ConfirmRequest emailConfirmRequestDto) {
        memberService.confirmEmail(emailConfirmRequestDto);
        return ResponseEntity.ok(ApiResponse.readSuccess());
    }
}
