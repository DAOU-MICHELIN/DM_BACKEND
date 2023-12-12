package com.michelinguide.daou.auth.controller;

import com.michelinguide.daou.auth.dtos.EmailDto;
import com.michelinguide.daou.auth.dtos.MemberDto;
import com.michelinguide.daou.auth.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    @PostMapping("/join")
    ResponseEntity join(@RequestBody MemberDto.JoinRequest request){
        Long savedId = memberService.save(request);
        log.info("Registered ID = {}", savedId);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/confirm-email")
    ResponseEntity confirmEmail(@RequestBody EmailDto.ConfirmRequest emailConfirmRequestDto) {
        memberService.confirmEmail(emailConfirmRequestDto);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
