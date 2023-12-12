package com.michelinguide.daou.auth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailAuth {

    private static final Long MAX_EXPIRE_TIME = 5L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id ;

    private String email;

    private String authCode;

    private boolean expired;

    private LocalDateTime expiredDateTime;

    @Builder
    public EmailAuth(String email, String authCode) {
        this.email = email;
        this.authCode = authCode;
        this.expiredDateTime = LocalDateTime.now().plusMinutes(MAX_EXPIRE_TIME);
    }


    public void useToken () {
        this.expired = true;
    }

}
