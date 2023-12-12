package com.michelinguide.daou.auth.token;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@RedisHash(value = "jwtToken", timeToLive = 60 * 60 * 24 * 3)
@Builder
public class RefreshToken {

    @Id
    private String id ;

    @Indexed
    private String accessToken;

    private String refreshToken;

}
