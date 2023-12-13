package com.michelinguide.daou.auth.dtos;

import com.michelinguide.daou.auth.validation.AllowedEmailDomain;
import jakarta.validation.constraints.Email;
import lombok.Getter;

public class EmailDto {

    @Getter
    public static class ConfirmRequest {

        @Email
        @AllowedEmailDomain(allowedDomain = "daou.co.kr")
        private String email;

    }

}
