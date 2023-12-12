package com.michelinguide.daou.auth.dtos;

import lombok.Getter;

public class EmailDto {

    @Getter
    public static class ConfirmRequest {

        private String email;

        private String authCode;
    }

}
