package com.michelinguide.daou.auth.controller;

import com.michelinguide.daou.auth.dto.Email;
import com.michelinguide.daou.auth.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EmailController {

    private final EmailService emailService;
    @PostMapping
    public ResponseEntity sendMail() {
        Email email = Email.builder()
                           .to("yesiam@daou.co.kr")
                           .subject("테스트 메일 제목")
                           .message("테스트 메일 본문")
                           .build();
        emailService.sendEmail(email);
        return new ResponseEntity(HttpStatus.OK);
    }
}
