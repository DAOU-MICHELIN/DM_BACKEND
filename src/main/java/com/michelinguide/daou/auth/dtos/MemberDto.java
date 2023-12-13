package com.michelinguide.daou.auth.dtos;

import com.michelinguide.daou.auth.entity.Member;
import lombok.Getter;

public class MemberDto {

    @Getter
    public static class JoinRequest {

        private String email;

        private String password;

        private String nickname;

        private String authCode;

        public Member toEntity () {
            return Member.builder()
                         .email(email)
                         .password(password)
                         .nickname(nickname)
                         .build();
        }
    }

}
