package com.michelinguide.daou.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Email {

    private String to;

    private String subject;

    private String message;

}
